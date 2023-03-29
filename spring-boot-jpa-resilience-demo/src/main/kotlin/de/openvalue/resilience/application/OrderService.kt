package de.openvalue.resilience.application

import de.openvalue.resilience.adapter.repository.OrderRepository
import de.openvalue.resilience.domain.OrderEntity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderService(val orderRepository: OrderRepository) {

    @Transactional
    fun create(order: OrderEntity): OrderEntity {
        return orderRepository.save(order)
    }

}