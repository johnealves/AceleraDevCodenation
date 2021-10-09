package br.com.codenation.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

public class OrderServiceImpl implements OrderService {

	private ProductRepository productRepository = new ProductRepositoryImpl();

	/**
	 * Calculate the sum of all OrderItems
	 */
	@Override
	public Double calculateOrderValue(List<OrderItem> items) {
		return items
				.stream()
				.filter(item -> this.productRepository.findById(item.getProductId()).isPresent())
				.mapToDouble(item -> {
					Product product = this.productRepository.findById(item.getProductId()).get();
					Double total;
					if (product.getIsSale()) {
						total = item.getQuantity() * (product.getValue() * 0.8);
					} else {
						total = item.getQuantity() * product.getValue();
					}
					return total;
				}).sum();
	}

	/**
	 * Map from idProduct List to Product Set
	 */
	@Override
	public Set<Product> findProductsById(List<Long> ids) {
		return ids
				.stream()
				.filter(id -> this.productRepository.findById(id).isPresent())
				.map(id -> this.productRepository.findById(id).get())
				.collect(Collectors.toSet());
	}

	/**
	 * Calculate the sum of all Orders(List<OrderIten>)
	 */
	@Override
	public Double calculateMultipleOrders(List<List<OrderItem>> orders) {
		Double orderValue = 0d;
		orders.stream().map(this::calculateOrderValue);
		return orderValue;
	}

	/**
	 * Group products using isSale attribute as the map key
	 */
	@Override
	public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {
		return productIds
				.stream()
				.filter(id -> id > 0 && id != null)
				.map(id -> productRepository.findById(id).get())
				.collect(Collectors.toList())
				.stream()
				.collect(Collectors.groupingBy(Product::getIsSale));
	}

}