import { __decorate } from "tslib";
import { Component } from '@angular/core';
import { WalletUser } from '../WalletUser';
let SignupComponent = class SignupComponent {
    constructor(router, walletsignupService) {
        this.router = router;
        this.walletsignupService = walletsignupService;
        this.walletUser = new WalletUser();
    }
    ngOnInit() {
        this.walletUser = new WalletUser();
    }
    signUp() {
        this.walletUser.userId = this.userId;
        this.walletUser.userName = this.userName;
        this.walletUser.password = this.password;
        this.walletUser.phoneNumber = this.phoneNumber;
        this.walletsignupService.createUser(this.walletUser).subscribe(data => {
            if (data == false) {
                console.log(data);
                this.isCorrect = false;
            }
            else {
                this.isCorrect = true;
                this.walletUser = new WalletUser();
                this.walletsignupService.createWalletAccount(this.userId).subscribe(data => {
                    this.walletsignupService.walletAccountId = data;
                    console.log(data);
                }, error => {
                    console.log(error);
                });
                alert("You are Registered Successfully");
                this.router.navigate(['/home']);
            }
        }, error => {
            console.log(error);
        });
    }
    validate() {
        if (this.userId == undefined || this.password == undefined ||
            this.phoneNumber == undefined || this.userName == undefined) {
            this.isValid = false;
        }
        else {
            this.isValid = true;
            this.signUp();
        }
    }
};
SignupComponent = __decorate([
    Component({
        selector: 'app-signup',
        templateUrl: './signup.component.html',
        styleUrls: ['./signup.component.css']
    })
], SignupComponent);
export { SignupComponent };
//# sourceMappingURL=signup.component.js.map