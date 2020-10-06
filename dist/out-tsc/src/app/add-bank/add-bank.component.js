import { __decorate } from "tslib";
import { Component } from '@angular/core';
import { User } from './User';
import { BankWallet } from '../bank-details/BankWallet';
let AddBankComponent = class AddBankComponent {
    constructor(router, walletsignupService, walletService) {
        this.router = router;
        this.walletsignupService = walletsignupService;
        this.walletService = walletService;
        this.userDetails = new User();
        this.bankWallet = new BankWallet();
    }
    ngOnInit() {
        this.checkBankInfo();
    }
    checkBankInfo() {
        this.walletService.checkBanktoWallet(this.walletsignupService.
            walletAccountId).subscribe(data => {
            if (data) {
                this.router.navigate(['/bank-details']);
            }
        }, error => {
            console.log(error);
        });
    }
    addAccount() {
        this.userDetails.accountNo = this.accountNo;
        this.userDetails.holderName = this.holderName;
        this.userDetails.ifscCode = this.ifscCode;
        this.userDetails.bankName = this.bankName;
        this.bankWallet.walletAccountId = this.walletsignupService.walletAccountId;
        this.bankWallet.bankAccountId = this.userDetails.accountNo;
        this.walletService.addBanktoWallet(this.bankWallet).subscribe(data => {
            console.log(data);
        }, error => {
            console.log(error);
        });
        this.walletService.addBankAccount(this.userDetails)
            .subscribe(data => {
            console.log(data);
            this.router.navigate(['/bank-details']);
        });
    }
    validate() {
        if (this.bankName == undefined || this.holderName == undefined || this.ifscCode == undefined || this.accountNo == undefined) {
            this.isValid = false;
        }
        else {
            this.isValid = true;
            this.addAccount();
        }
    }
};
AddBankComponent = __decorate([
    Component({
        selector: 'app-add-bank',
        templateUrl: './add-bank.component.html',
        styleUrls: ['./add-bank.component.css']
    })
], AddBankComponent);
export { AddBankComponent };
//# sourceMappingURL=add-bank.component.js.map