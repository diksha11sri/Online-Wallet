import { __decorate } from "tslib";
import { Injectable } from '@angular/core';
let WalletService = class WalletService {
    constructor(http) {
        this.http = http;
        this.baseUrl = "http://localhost:8060";
    }
    createTransaction(transaction) {
        return this.http.post(`${this.baseUrl + "/transaction"}`, transaction, { responseType: 'text' });
    }
    getTransactionList(accountId) {
        return this.http.get(`${this.baseUrl + "/transactionList"}/${accountId}`);
    }
    getAccountBalance(accountId) {
        return this.http.get(`${this.baseUrl + "/getBalance"}/${accountId}`);
    }
    getWalletAccountInfo(accountId) {
        return this.http.get(`${this.baseUrl + "/WalletAccount/seeWalletAccount/"}/${accountId}`);
    }
    payDthBill(dthBill) {
        return this.http.post(`${this.baseUrl + "/pay"}`, dthBill, { responseType: 'text' });
    }
    addMoney(amount, accountId) {
        return this.http.get(`${this.baseUrl + "/addMoney"}/${accountId}/${amount}`);
    }
    addBankAccount(userDetails) {
        return this.http.post(this.baseUrl + "/add", userDetails);
    }
    addBanktoWallet(bankWallet) {
        return this.http.post(this.baseUrl + "/addBankWallet", bankWallet);
    }
    checkBanktoWallet(walletAccountId) {
        return this.http.get(`${this.baseUrl + "/check"}/${walletAccountId}`);
    }
    getBankAccountDetails(walletAccountId) {
        return this.http.get(`${this.baseUrl + "/findBankDetails"}/${walletAccountId}`);
    }
    doRegistration(BillDetails) {
        alert('Your bill registered successfully');
        return this.http.post(`${this.baseUrl + "/register"}`, BillDetails);
    }
    viewAccountById(billNo) {
        return this.http.get(`${this.baseUrl + "/viewAccountById"}/${billNo}`);
    }
    payElectricityBill(walletId, billAmount) {
        let queryString = '?walletId=' + walletId + '&billAmount=' + billAmount;
        return this.http.get(`${this.baseUrl}` + `/payElectricityBill/` + queryString);
    }
};
WalletService = __decorate([
    Injectable({
        providedIn: 'root'
    })
], WalletService);
export { WalletService };
//# sourceMappingURL=wallet.service.js.map