import { async, TestBed } from '@angular/core/testing';
import { TransferMoneyComponent } from './transfer-money.component';
describe('TransferMoneyComponent', () => {
    let component;
    let fixture;
    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [TransferMoneyComponent]
        })
            .compileComponents();
    }));
    beforeEach(() => {
        fixture = TestBed.createComponent(TransferMoneyComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });
    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
//# sourceMappingURL=transfer-money.component.spec.js.map