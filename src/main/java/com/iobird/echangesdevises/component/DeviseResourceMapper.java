package com.iobird.echangesdevises.component;

import com.iobird.echangesdevises.controller.DevisesController;
import com.iobird.echangesdevises.dto.DeviseDto;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class DeviseResourceMapper implements ResourceAssembler<DeviseDto, Resource<DeviseDto>> {

    @Override
    public Resource<DeviseDto> toResource(DeviseDto devise) {
        return new Resource<>(devise, linkTo(methodOn(DevisesController.class).findById(devise.getId())).withSelfRel(),
                linkTo(methodOn(DevisesController.class).list()).withRel("devises"));
    }
}
