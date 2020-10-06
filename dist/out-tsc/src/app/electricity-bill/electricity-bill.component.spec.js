import { async, TestBed } from '@angular/core/testing';
import { ElectricityBillComponent } from './electricity-bill.component';
describe('ElectricityBillComponent', () => {
    let component;
    let fixture;
    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [ElectricityBillComponent]
        })
            .compileComponents();
    }));
    beforeEach(() => {
        fixture = TestBed.createComponent(ElectricityBillComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });
    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
//# sourceMappingURL=electricity-bill.component.spec.js.map