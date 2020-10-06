import { __decorate } from "tslib";
import { Component } from '@angular/core';
let AddMoneyComponent = class AddMoneyComponent {
    constructor(walletService, router, walletsignupService) {
        this.walletService = walletService;
        this.router = router;
        this.walletsignupService = walletsignupService;
        this.valid = true;
    }
    ngOnInit() {
        this.checkBankInfo();
        this.getBalance();
    }
    getBalance() {
        this.walletService.getAccountBalance(this.walletsignupService.walletAccountId).subscribe(data => {
            this.balance = data;
        });
    }
    addMoney() {
        this.walletService.addMoney(this.amount, this.walletsignupService.walletAccountId).subscribe(data => {
            console.log(data);
        }, error => {
            console.log(error);
        });
        alert("Amount Added Successfully");
        this.router.navigate(['/home']);
    }
    checkBankInfo() {
        this.walletService.checkBanktoWallet(this.walletsignupService.
            walletAccountId).subscribe(data => {
            if (!data) {
                this.valid = false;
                document.getElementById("addButton").disabled = true;
            }
        }, error => {
            console.log(error);
        });
    }
};
AddMoneyComponent = __decorate([
    Component({
        selector: 'app-add-money',
        templateUrl: './add-money.component.html',
        styleUrls: ['./add-money.component.css']
    })
], AddMoneyComponent);
export { AddMoneyComponent };
//# sourceMappingURL=add-money.component.js.map