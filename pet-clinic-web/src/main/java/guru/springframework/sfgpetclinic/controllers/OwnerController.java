package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.business.abstracts.OwnerService;
import guru.springframework.sfgpetclinic.entities.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("/owners")
@Controller
public class OwnerController {
    private OwnerService ownerService;
    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping("/find")
    public String findOwners(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }

    @GetMapping
    public String processFindForm(Owner owner, BindingResult result, Model model) {
        // allow parameterless GET request for /owners to return all records
        if (owner.getLastName() == null) {
           owner.setLastName(""); // empty string signifies the broadest possible search
        }

        // find owners by last name
        //List<Owner> ownersResults = ownerService.findAllByLastNameLike("%" + owner.getLastName().toUpperCase().charAt(0) + owner.getLastName().substring(1) + "%");
        List<Owner> ownersResults = ownerService.findAllByLastNameLike("%"+ owner.getLastName() + "%");

        if (ownersResults.isEmpty()) {
            // no owners found
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        }

        else if (ownersResults.size() == 1) {
            // 1 owner found
            owner = ownersResults.get(0);
            return "redirect:/owners/" + owner.getId();
        } else {

            // multiple owners found
            model.addAttribute("selections", ownersResults);
            return "owners/ownersList";
        }
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        Owner owner = this.ownerService.findById(ownerId);
        mav.addObject(owner);
        return mav;
    }

    @GetMapping("/new")
    public String initCreationForm(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/new")
    public String processCreationForm(@Valid Owner owner, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        }

        Owner savedOwner = this.ownerService.save(owner);
        return "redirect:/owners/" + savedOwner.getId();
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable Long ownerId, Model model) {
        model.addAttribute(ownerService.findById(ownerId));
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm(@Valid Owner owner, BindingResult result,
                                         @PathVariable Long ownerId) {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        }

        owner.setId(ownerId);
        Owner savedOwner = this.ownerService.save(owner);
        return "redirect:/owners/" + savedOwner.getId();
    }
}

