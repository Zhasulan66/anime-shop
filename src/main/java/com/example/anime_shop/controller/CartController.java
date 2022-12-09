package com.example.anime_shop.controller;

import com.example.anime_shop.global.GlobalData;
import com.example.anime_shop.model.Order;
import com.example.anime_shop.model.Product;
import com.example.anime_shop.service.OrderService;
import com.example.anime_shop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartController {

    final ProductService productService;
    final OrderService orderService;

    public CartController(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable int id){
        GlobalData.cart.add(productService.getProductById(id).get());
        return "redirect:/shop";
    }

    @GetMapping("/cart")
    public String cartGet(Model model){
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        model.addAttribute("cart", GlobalData.cart);
        return "cart";
    }

    @GetMapping("/cart/removeItem/{index}")
    public String cartItemRemove(@PathVariable int index){
        GlobalData.cart.remove(index);
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout(Model model){
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        model.addAttribute("cart", GlobalData.cart);
        model.addAttribute("order", new Order());
        return "checkout";
    }

    @PostMapping("/order/add")
    public String makeOrder(@ModelAttribute("order") Order order){
        order.setTotal_price(GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        order.setProducts(GlobalData.cart);
        orderService.addOrder(order);
        GlobalData.cart.clear();
        return "orderPlaced";
    }


}
