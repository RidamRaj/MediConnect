package com.wecp.progressive.service.impl;

import com.wecp.progressive.entity.Billing;
import com.wecp.progressive.repository.BillingRepository;
import com.wecp.progressive.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingServiceImpl implements BillingService {

    @Autowired
    private BillingRepository billingRepository;

    @Override
    public List<Billing> getAllBills() throws Exception {
        return billingRepository.findAll();
    }

    @Override
    public Billing getBillById(int billingId) throws Exception {
        return billingRepository.findById(billingId)
                .orElseThrow(() -> new Exception("Billing record not found with ID: " + billingId));
    }

    @Override
    public Integer createBill(Billing billing) throws Exception {
        return billingRepository.save(billing).getBillingId();
    }

    @Override
    public void deleteBill(int billingId) throws Exception {
        if (!billingRepository.existsById(billingId)) {
            throw new Exception("Billing record not found with ID: " + billingId);
        }
        billingRepository.deleteById(billingId);
    }

    @Override
    public List<Billing> getBillsByPatientId(int patientId) throws Exception {
        return billingRepository.findAllByPatient_PatientId(patientId);
    }
}
