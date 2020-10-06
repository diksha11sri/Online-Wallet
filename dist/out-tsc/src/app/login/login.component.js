import { __decorate } from "tslib";
import { Component } from '@angular/core';
import { WalletUser } from '../WalletUser';
let LoginComponent = class LoginComponent {
    constructor(router, walletsignupService) {
        this.router = router;
        this.walletsignupService = walletsignupService;
        this.walletUser = new WalletUser();
    }
    ngOnInit() {
        this.walletUser = new WalletUser();
    }
    onLogin() {
        this.walletUser.userId = this.userId;
        this.walletUser.password = this.password;
        this.walletsignupService.checkLoginDetails(this.walletUser).subscribe(data => {
            if (data == "Login Successful") {
                this.isRightUser = true;
                this.isValid = true;
                this.walletsignupService.mapUserWallet(this.userId).subscribe(data => {
                    this.walletsignupService.walletAccountId = data;
                    console.log(data);
                    this.router.navigate(['/home']);
                }, error => {
                    console.log(error);
                });
            }
            else {
                this.isRightUser = false;
            }
        });
    }
    validate() {
        if (this.userId == undefined || this.password == undefined) {
            this.isValid = false;
        }
        else {
            this.isValid = true;
            this.onLogin();
        }
    }
};
LoginComponent = __decorate([
    Component({
        selector: 'app-login',
        templateUrl: './login.component.html',
        styleUrls: ['./login.component.css']
    })
], LoginComponent);
export { LoginComponent };
//# sourceMappingURL=login.component.js.map