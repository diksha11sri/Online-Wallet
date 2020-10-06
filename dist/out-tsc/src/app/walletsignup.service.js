import { __decorate } from "tslib";
import { Injectable } from '@angular/core';
let WalletsignupService = class WalletsignupService {
    constructor(http) {
        this.http = http;
        this.basurl1 = "http://localhost:8085/loginpage";
        this.baseurl2 = "http://localhost:8060";
    }
    createUser(walletUser) {
        return this.http.post(`${this.basurl1 + "/register"}`, walletUser);
    }
    createWalletAccount(userId) {
        return this.http.get(`${this.baseurl2 + "/create"}/${userId}`);
    }
    checkLoginDetails(walletUser) {
        return this.http.post(`${this.basurl1 + "/login"}`, walletUser, { responseType: 'text' });
    }
    mapUserWallet(uid) {
        return this.http.get(`${this.baseurl2 + "/getWalletAccountId"}/${uid}`);
    }
};
WalletsignupService = __decorate([
    Injectable({
        providedIn: 'root'
    })
], WalletsignupService);
export { WalletsignupService };
//# sourceMappingURL=walletsignup.service.js.map