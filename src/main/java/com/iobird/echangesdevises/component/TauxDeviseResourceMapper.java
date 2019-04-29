package com.iobird.echangesdevises.component;

import com.iobird.echangesdevises.controller.DevisesController;
import com.iobird.echangesdevises.controller.TauxDeviseController;
import com.iobird.echangesdevises.dto.TauxDeviseDto;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class TauxDeviseResourceMapper implements ResourceAssembler<TauxDeviseDto, Resource<TauxDeviseDto>> {

    @Override
    public Resource<TauxDeviseDto> toResource(TauxDeviseDto tauxDeviseDto) {
        return new Resource<>(tauxDeviseDto, linkTo(methodOn(TauxDeviseController.class).list()).withRel("taux-devises"),
                linkTo(methodOn(DevisesController.class).findById(tauxDeviseDto.getId())).withSelfRel()
        );
    }
}
