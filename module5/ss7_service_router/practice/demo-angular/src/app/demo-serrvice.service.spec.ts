import { TestBed } from '@angular/core/testing';

import { DemoSerrviceService } from './demo-serrvice.service';

describe('DemoSerrviceService', () => {
  let service: DemoSerrviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DemoSerrviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
