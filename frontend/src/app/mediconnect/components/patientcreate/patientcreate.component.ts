import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MediConnectService } from '../../services/mediconnect.service';
import { Patient } from '../../models/Patient';
@Component({
  selector: 'app-patientcreate',
  templateUrl: './patientcreate.component.html',
  styleUrls: ['./patientcreate.component.scss']
})
export class PatientCreateComponent {
  patientForm!: FormGroup;
  successMessage: string | null = null;
  errorMessage: string | null = null;
  constructor(private fb: FormBuilder, private medService: MediConnectService) {
this.patientForm = this.fb.group({
      fullName: ['', Validators.required],
      dob: ['', Validators.required],
      contactNumber: ['', Validators.required]
    });
  }
  onSubmit(): void {
    if (this.patientForm.invalid) return;
    const patient: Patient = this.patientForm.value;
    this.medService.createPatient(patient).subscribe({
      next: () => {
        this.successMessage = 'Patient created successfully!';
        this.errorMessage = null;
        this.patientForm.reset();
      },
      error: () => {
        this.errorMessage = 'Failed to create patient';
        this.successMessage = null;
      }
    });
  }
}