import { async, TestBed } from '@angular/core/testing';
import { DisplayPassbookComponent } from './display-passbook.component';
describe('DisplayPassbookComponent', () => {
    let component;
    let fixture;
    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [DisplayPassbookComponent]
        })
            .compileComponents();
    }));
    beforeEach(() => {
        fixture = TestBed.createComponent(DisplayPassbookComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });
    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
//# sourceMappingURL=display-passbook.component.spec.js.map