import { __decorate } from "tslib";
import { Component } from '@angular/core';
import { User } from '../add-bank/User';
let BankDetailsComponent = class BankDetailsComponent {
    constructor(router, walletsignupService, walletService) {
        this.router = router;
        this.walletsignupService = walletsignupService;
        this.walletService = walletService;
        this.user = new User();
    }
    ngOnInit() {
        this.show();
    }
    show() {
        this.userObj = this.walletService.getBankAccountDetails(this.walletsignupService.walletAccountId);
        this.userObj.subscribe(data => {
            this.user = data;
        });
    }
};
BankDetailsComponent = __decorate([
    Component({
        selector: 'app-bank-details',
        templateUrl: './bank-details.component.html',
        styleUrls: ['./bank-details.component.css']
    })
], BankDetailsComponent);
export { BankDetailsComponent };
//# sourceMappingURL=bank-details.component.js.map