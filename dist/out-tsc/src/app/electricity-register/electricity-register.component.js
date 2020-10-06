import { __decorate } from "tslib";
import { Component } from '@angular/core';
import { BillDetails } from '../electricity-bill/BillDetails';
let ElectricityRegisterComponent = class ElectricityRegisterComponent {
    constructor(service) {
        this.service = service;
        this.BillDetails = new BillDetails();
    }
    ngOnInit() {
    }
    registerNow() {
        let resp = this.service.doRegistration(this.BillDetails);
        resp.subscribe((data) => this.message = data);
    }
    ;
};
ElectricityRegisterComponent = __decorate([
    Component({
        selector: 'app-electricity-register',
        templateUrl: './electricity-register.component.html',
        styleUrls: ['./electricity-register.component.css']
    })
], ElectricityRegisterComponent);
export { ElectricityRegisterComponent };
//# sourceMappingURL=electricity-register.component.js.map