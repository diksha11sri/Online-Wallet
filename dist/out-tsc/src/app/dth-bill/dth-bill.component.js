import { __decorate } from "tslib";
import { Component } from '@angular/core';
import { DthBill } from './DthBill';
let DthBillComponent = class DthBillComponent {
    constructor(walletService, router, walletsignupService) {
        this.walletService = walletService;
        this.router = router;
        this.walletsignupService = walletsignupService;
        this.dthBill = new DthBill();
    }
    ngOnInit() {
        this.dthBill = new DthBill();
    }
    payMoney() {
        this.dthBill.walletAccountId = this.walletsignupService.walletAccountId;
        this.dthBill.customerName = this.custname;
        this.dthBill.customerPhno = this.custphno;
        this.dthBill.amountPay = this.amount;
        this.walletService.payDthBill(this.dthBill).subscribe(data => {
            console.log(data);
            alert("Bill paid successfully");
        }, error => {
            console.log(error);
        });
        this.router.navigate(['/home']);
    }
};
DthBillComponent = __decorate([
    Component({
        selector: 'app-dth-bill',
        templateUrl: './dth-bill.component.html',
        styleUrls: ['./dth-bill.component.css']
    })
], DthBillComponent);
export { DthBillComponent };
//# sourceMappingURL=dth-bill.component.js.map