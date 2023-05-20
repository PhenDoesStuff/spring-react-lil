package com.stephenmontague.wisdompet.web.rest;

import com.stephenmontague.wisdompet.services.VendorService;
import com.stephenmontague.wisdompet.web.errors.BadRequestException;
import com.stephenmontague.wisdompet.web.models.Vendor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Objects;

public class VendorRestController {

    private final VendorService vendorService;

    public VendorRestController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Vendor> getAll() {
        return this.vendorService.getVendors();
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public Vendor createVendor(@RequestBody Vendor product) {
        return this.vendorService.createOrUpdateVendor(product);
    }

    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Vendor getVendor(@PathVariable("id") Long id) {
        return this.vendorService.getVendor(id);
    }

    @PutMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Vendor updateVendor(@PathVariable("id") Long id, @RequestBody Vendor product) {
        if (!Objects.equals(id, product.getVendorId())) {
            throw new BadRequestException("IDs do not match");
        }

        return this.vendorService.createOrUpdateVendor(product);
    }

    @DeleteMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteVendor(@PathVariable("id") Long id) {
        this.vendorService.deleteVendor(id);
    }
}
