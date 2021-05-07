package com.example.starbuckscashiers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.example.starbuckscashiers.Ingredients.Type;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/design")
public class StarbucksController {
    @GetMapping
    public String showOrderForm(Model model) {
        List<Ingredients> ingredients = Arrays.asList(new Ingredients("TLL", "Tall", Type.SIZE),
                new Ingredients("GRN", "Grande", Type.SIZE), new Ingredients("VEN", "Venti", Type.SIZE),
                new Ingredients("YOC", "Your own cup", Type.SIZE), new Ingredients("NF", "Nonfat", Type.MILK),
                new Ingredients("WH", "Whole", Type.MILK), new Ingredients("TWOP", "2 %", Type.MILK),
                new Ingredients("ALM", "Almond", Type.MILK));

        Type[] types = Ingredients.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }

        model.addAttribute("design", new Coffee());
        return "design";
    }

    private List<Ingredients> filterByType(<Ingredients> ingredients, Type type) {
              return ingredients
              .stream()
              .filter(x -> x.getType().equals(type))
              .collect(Collectors.toList());
      }
    }
