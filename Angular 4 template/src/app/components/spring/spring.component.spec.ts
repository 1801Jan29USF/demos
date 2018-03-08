import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SpringComponent } from './spring.component';

describe('SpringComponent', () => {
  let component: SpringComponent;
  let fixture: ComponentFixture<SpringComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SpringComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SpringComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
