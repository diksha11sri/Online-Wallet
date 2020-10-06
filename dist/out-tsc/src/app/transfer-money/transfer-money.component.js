import { __decorate } from "tslib";
import { Component } from '@angular/core';
import { WalletTransaction } from './WalletTransaction';
let TransferMoneyComponent = class TransferMoneyComponent {
    constructor(walletService, router, walletsignupService) {
        this.walletService = walletService;
        this.router = router;
        this.walletsignupService = walletsignupService;
        this.transaction = new WalletTransaction();
        this.message = false;
    }
    ngOnInit() {
        this.getBalance();
    }
    transferMoney() {
        this.transaction.accountId = this.walletsignupService.walletAccountId;
        this.transaction.amount = this.amount;
        this.transaction.accountBalance = this.accountBalance;
        this.transaction.description = this.transferType;
        this.transaction.receiverAccountId = this.accountId;
        this.transaction.dateOfTransaction = new Date();
        this.walletService.createTransaction(this.transaction).subscribe(data => {
            console.log(data);
            this.message = true;
        }, error => {
            console.log(error);
        });
        this.transaction = new WalletTransaction();
    }
    back() {
        this.router.navigate(['/home']);
    }
    getBalance() {
        this.walletService.getAccountBalance(this.walletsignupService.
            walletAccountId).subscribe(data => {
            console.log(data);
            this.accountBalance = data;
        }, error => {
            console.log(error);
        });
    }
};
TransferMoneyComponent = __decorate([
    Component({
        selector: 'app-transfer-money',
        templateUrl: './transfer-money.component.html',
        styleUrls: ['./transfer-money.component.css']
    })
], TransferMoneyComponent);
export { TransferMoneyComponent };
//# sourceMappingURL=transfer-money.component.js.map