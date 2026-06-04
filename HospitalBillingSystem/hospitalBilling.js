class HospitalBillingSystem {
  constructor() {
    this.patients = [];
  }

  addPatients(name, treatmentType, cost, days) {
    this.patients.push({ name, treatmentType, cost, days });
  }

  removePatients(name) {
    this.patients = this.patients.filter((patient) => patient.name != name);
  }

  calculateTotalBill() {
    let total = 0;

    this.patients.forEach((patient) => {
      total += patient.cost * patient.days;
    });

    return total;
  }

  applyInsuranceDiscount(code) {
    let total = this.calculateTotalBill();

    if (code === "INSURE10") {
      return total - total * 0.1;
    }

    return total;
  }

  calculateMedicalTax(tax) {
    let total = this.calculateTotalBill();

    return total * tax;
  }

  finalBilling(code, tax) {
    let total = this.applyInsuranceDiscount(code);

    let medicalTax = total * tax;

    let amount = total + medicalTax;

    this.patients = [];

    return amount;
  }
}

module.exports = HospitalBillingSystem;
