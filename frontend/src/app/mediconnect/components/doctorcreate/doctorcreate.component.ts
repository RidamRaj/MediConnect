import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MediConnectService } from '../../services/mediconnect.service';
import { Doctor } from '../../models/Doctor';
@Component({
  selector: 'app-doctorcreate',
  templateUrl: './doctorcreate.component.html',
  styleUrls: ['./doctorcreate.component.scss']
})
export class DoctorCreateComponent {
  doctorForm!: FormGroup;
  successMessage: string | null = null;
  errorMessage: string | null = null;
  constructor(private fb: FormBuilder, private medService: MediConnectService) {
this.doctorForm = this.fb.group({
      fullName: ['', Validators.required],
email: ['', [Validators.required, Validators.email]],
      specialty: ['', Validators.required],
      yearsOfExperience: ['', Validators.required],
      contactNumber: ['', Validators.required]
    });
  }
  onSubmit(): void {
    if (this.doctorForm.invalid) return;
    const doctor: Doctor = this.doctorForm.value;
    this.medService.createDoctor(doctor).subscribe({
      next: () => {
        this.successMessage = 'Doctor created successfully!';
        this.errorMessage = null;
        this.doctorForm.reset();
      },
      error: () => {
        this.errorMessage = 'Failed to create doctor';
        this.successMessage = null;
      }
    });
  }
}