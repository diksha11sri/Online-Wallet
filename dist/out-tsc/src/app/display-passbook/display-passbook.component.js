import { __decorate } from "tslib";
import { Component } from '@angular/core';
import { WalletAccount } from '../signup/WalletAccount';
let DisplayPassbookComponent = class DisplayPassbookComponent {
    constructor(walletService, router, datePipe, walletsignupService) {
        this.walletService = walletService;
        this.router = router;
        this.datePipe = datePipe;
        this.walletsignupService = walletsignupService;
        this.walletAccount = new WalletAccount();
    }
    ngOnInit() {
        this.reloadData();
        this.walletAccount = new WalletAccount();
    }
    reloadData() {
        this.accountNumber = this.walletsignupService.walletAccountId;
        this.transactions = this.walletService.getTransactionList(this.accountNumber);
        this.walletService.getAccountInfo(this.accountNumber).subscribe(data => {
            this.walletAccount = data;
            console.log(data);
        }, error => {
            console.log("error" + error);
        });
    }
};
DisplayPassbookComponent = __decorate([
    Component({
        selector: 'app-display-passbook',
        templateUrl: './display-passbook.component.html',
        styleUrls: ['./display-passbook.component.css']
    })
], DisplayPassbookComponent);
export { DisplayPassbookComponent };
//# sourceMappingURL=display-passbook.component.js.map