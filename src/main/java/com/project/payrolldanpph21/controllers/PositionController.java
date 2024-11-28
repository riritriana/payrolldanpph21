package com.project.payrolldanpph21.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.project.payrolldanpph21.models.Position;
import com.project.payrolldanpph21.services.PositionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class PositionController {
    @Autowired
    private PositionService positionService;

    @GetMapping("/position")
    public String position(Model model) {
        List<Position> position = positionService.getAllPositions();
        model.addAttribute("position", position);
        return "/position/position";
    }
    
    @GetMapping("/add-position")
    public String addPosition(Model model) {
        List<Position> position = new ArrayList<>();
        model.addAttribute("position", position);
        return "/position/add-position";
    }

    @PostMapping("/save-position")
    public String savePosition(Position position, Model model){
        positionService.save(position);
        return "redirect:/add-position";
    }
    
    @GetMapping("delete-position/{id}")
    public String deletePosition(@PathVariable(value = "id") Long id, Model model) {
        positionService.delete(id);
        return "redirect:/position";
    }
    
        @GetMapping("update-position/{id}")
    public String updateposition(@PathVariable(value = "id") Long id, Model model) {
        Position position = positionService.findById(id);
        model.addAttribute("position", position);
        return "/position/update-position";
    }

    @PostMapping("save-update-position/{id}")
    public String saveUpdate(@PathVariable(value = "id") Long id, @ModelAttribute("position") Position position, Model model){
        Position update = positionService.findById(id);
        if (update != null) {
            update.setPositionName(position.getPositionName());
            update.setBasicSalary(position.getBasicSalary());
            positionService.save(position);
        }
        return "redirect:/position";
    }

    
    

}
