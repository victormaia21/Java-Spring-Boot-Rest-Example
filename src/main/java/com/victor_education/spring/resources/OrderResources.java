package com.victor_education.spring.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victor_education.spring.dto.OrderDto;
import com.victor_education.spring.entities.Order;
import com.victor_education.spring.responses.Message;
import com.victor_education.spring.services.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/orders")
@Tag(name = "Orders", description = "Endpoints para gerenciar pedidos")
public class OrderResources {

    @Autowired
    private OrderService service;

    @GetMapping
    @Operation(summary = "Obter todos os pedidos", description = "Retorna uma lista paginada de pedidos.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pedidos encontrados"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<Page<Order>> findAll(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter pedido por ID", description = "Retorna um pedido específico pelo ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pedido encontrado"),
        @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
    })
    public ResponseEntity<Optional<Order>> findById(@PathVariable Long id) {
        Optional<Order> order = service.findById(id);
        if (order.isPresent()) {
            return ResponseEntity.ok().body(order);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    @Operation(summary = "Criar novo pedido", description = "Cria um novo pedido.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Pedido criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos")
    })
    public ResponseEntity<Order> createOrder(@RequestBody OrderDto order) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createOrder(order));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar pedido por ID", description = "Atualiza um pedido existente pelo ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pedido atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Pedido não encontrado"),
        @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos")
    })
    public ResponseEntity<Order> updateOrderById(@RequestBody OrderDto order, @PathVariable Long id) {
        Optional<Order> updatedOrder = service.findById(id);
        if (updatedOrder.isPresent()) {
            return ResponseEntity.ok().body(service.updateOrderById(order, id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir pedido por ID", description = "Exclui um pedido existente pelo ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pedido excluído com sucesso"),
        @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
    })
    public ResponseEntity<Message> deleteOrderById(@PathVariable Long id) {
        Optional<Order> order = service.findById(id);
        if (order.isPresent()) {
            return ResponseEntity.ok().body(service.deleteOrderById(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
