import { TestBed } from '@angular/core/testing';
import { WalletsignupService } from './walletsignup.service';
describe('WalletsignupService', () => {
    let service;
    beforeEach(() => {
        TestBed.configureTestingModule({});
        service = TestBed.inject(WalletsignupService);
    });
    it('should be created', () => {
        expect(service).toBeTruthy();
    });
});
//# sourceMappingURL=walletsignup.service.spec.js.map