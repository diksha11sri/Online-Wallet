import { async, TestBed } from '@angular/core/testing';
import { ElectricityRegisterComponent } from './electricity-register.component';
describe('ElectricityRegisterComponent', () => {
    let component;
    let fixture;
    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [ElectricityRegisterComponent]
        })
            .compileComponents();
    }));
    beforeEach(() => {
        fixture = TestBed.createComponent(ElectricityRegisterComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });
    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
//# sourceMappingURL=electricity-register.component.spec.js.map