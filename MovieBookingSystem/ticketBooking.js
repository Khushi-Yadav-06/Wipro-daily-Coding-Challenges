class MovieTicketBookingSystem {
  constructor() {
    this.tickets = [];
  }

  addTicket(movieName, seatType, ticketPrice, quantity) {
    this.tickets.push({
      movieName,
      seatType,
      ticketPrice,
      quantity,
    });
  }

  removeTicket(movieName) {
    this.tickets = this.tickets.filter(
      (ticket) => ticket.movieName !== movieName,
    );
  }

  calculateTotalAmount() {
    let total = 0;

    this.tickets.forEach((ticket) => {
      total += ticket.ticketPrice * ticket.quantity;
    });

    return total;
  }

  applyOffer(code) {
    let total = this.calculateTotalAmount();

    if (code === "MOVIE10") {
      return total - total * 0.1;
    }

    return total;
  }

  calculateEntertainmentTax(tax) {
    let total = this.calculateTotalAmount();

    return total * tax;
  }

  finalBooking(code, tax) {
    let total = this.applyOffer(code);

    let entertainmentTax = total * tax;

    let finalAmount = total + entertainmentTax;

    this.tickets = [];

    return finalAmount;
  }
}

module.exports = MovieTicketBookingSystem;
