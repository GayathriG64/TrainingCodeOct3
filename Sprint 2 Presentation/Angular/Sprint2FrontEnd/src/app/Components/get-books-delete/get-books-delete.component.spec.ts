import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetBooksDeleteComponent } from './get-books-delete.component';

describe('GetBooksDeleteComponent', () => {
  let component: GetBooksDeleteComponent;
  let fixture: ComponentFixture<GetBooksDeleteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetBooksDeleteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetBooksDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
