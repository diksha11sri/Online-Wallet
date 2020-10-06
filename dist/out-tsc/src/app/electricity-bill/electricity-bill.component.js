import { __decorate } from "tslib";
import { Component } from '@angular/core';
import { BillDetails } from './BillDetails';
import { WalletAccount } from '../signup/WalletAccount';
let ElectricityBillComponent = class ElectricityBillComponent {
    constructor(service, signupservice, router) {
        this.service = service;
        this.signupservice = signupservice;
        this.router = router;
        this.BillDetails = new BillDetails();
        this.walletAccount = new WalletAccount();
    }
    ngOnInit() {
    }
    Search() {
        let resp = this.service.viewAccountById(this.billNo);
        resp.subscribe((data) => this.BillDetails = data);
    }
    Paybill() {
        this.paynow();
    }
    paynow() {
        this.billAmount = this.BillDetails.billAmount;
        this.walletId = this.signupservice.walletAccountId;
        this.service.payElectricityBill(this.walletId, this.BillDetails.billAmount).subscribe(data => {
            console.log(data);
        }, error => {
            console.log(error);
        });
        alert(' Your bill paid successfully.');
        this.router.navigate(['/home']);
    }
};
ElectricityBillComponent = __decorate([
    Component({
        selector: 'app-electricity-bill',
        templateUrl: './electricity-bill.component.html',
        styleUrls: ['./electricity-bill.component.css']
    })
], ElectricityBillComponent);
export { ElectricityBillComponent };
//# sourceMappingURL=electricity-bill.component.js.map