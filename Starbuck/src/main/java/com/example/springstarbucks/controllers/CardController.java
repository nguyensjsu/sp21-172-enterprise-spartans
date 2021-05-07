package com.example.springstarbucks.controllers;

import com.example.springstarbucks.servicesImpl.CardServiceImpl;
import com.example.springstarbucks.servicesImpl.OrderServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.example.springstarbucks.model.*;
import java.util.List;

@Controller
public class CardController {

	@Autowired
	CardServiceImpl cardServiceImpl;

	@Autowired
	OrderServiceImpl orderServiceImpl;


	@GetMapping("/")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "home";
	}

	//check the api's working correctly api
	@RequestMapping(value="/ping", method=RequestMethod.GET)
	@ResponseBody
	public String healthCheck() {
		return cardServiceImpl.healthcheck();
	}

	
	// ********************************* starbucks cards***************************************************//


	//get all the starbuck cards api
	@RequestMapping(value="/getcards", method=RequestMethod.GET)
	@ResponseBody
	public List<Cards> getAllStarBucksCards() {
		return cardServiceImpl.getAllStarbucksCards();
	}

	//Submit the starbuck card api
	@RequestMapping(value="/newcard", method=RequestMethod.POST)
	@ResponseBody
	public String createStarbucksCard(Cards cards) {
		return cardServiceImpl.postStarbucksCard(cards);
	}

	//find the starbucks card api 
	@RequestMapping(value="/findcard", method = RequestMethod.GET)
	@ResponseBody
	public Cards findStarbucksCard(@RequestParam("cardnumber") String cardNumber) {
		System.out.println(cardNumber);
		return cardServiceImpl.getSpecificStarbucksCard(cardNumber);
	}

	//Activate starbuck card api
	@RequestMapping(value="/card/activate", method=RequestMethod.POST)
	@ResponseBody
	public String activateStarbucksCard(@RequestParam("cardnumber") String cardNumber, @RequestParam("code") int code) {
		return cardServiceImpl.activateStarbucksCardTrue(cardNumber, code);
	}

	//delete all the starbucks records
	@RequestMapping(value="/cards", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteAllCards(){
		cardServiceImpl.deleteStarbucksCards();
	}



	// ********************************** Orders ****************************************************//


	//get all the Orders api
	@RequestMapping(value="/orders", method=RequestMethod.GET)
	@ResponseBody
	public List<Orders> getAllOrders() {
		return orderServiceImpl.getAllOrders();
	}

	//Submit the order api
	@RequestMapping(value="/order/register", method=RequestMethod.POST)
	@ResponseBody
	public Orders createOrder(Orders order) {
		return orderServiceImpl.createOrder(order);
	}


	//delete all the prder records
	@RequestMapping(value="/orders", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteAllOrders(){
		orderServiceImpl.deleteAllOrders();
	}


	//find the current order api 
	@RequestMapping(value="/findorder", method = RequestMethod.GET)
	@ResponseBody
	public Orders findCurrentOrder(@RequestParam("id") int id) {
		return orderServiceImpl.getSpecificOrder(id);
	}


	//find the starbucks card api 
	@RequestMapping(value="/deleteorder", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteActiveOrder(@RequestParam("id") int id) {
		return orderServiceImpl.deleteActiveOrder(id);
	}


	//Submit the order api
	@RequestMapping(value="/order/pay", method=RequestMethod.POST)
	@ResponseBody
	public Cards paytheOrder(@RequestParam("cardnumber") String cardNumber, @RequestParam("orderid") int orderid) {
		return orderServiceImpl.paytheOrders(cardNumber, orderid);
	}
}

