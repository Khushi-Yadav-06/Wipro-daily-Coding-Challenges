// const MovieTicketBookingSystem = require("../movieTicketBooking");
const MovieTicketBookingSystem = require("../ticketBooking");

describe("Movie Ticket Booking System", () => {
  let movie;

  beforeEach(() => {
    movie = new MovieTicketBookingSystem();
  });

  test("should add ticket", () => {
    movie.addTicket("Avengers", "Gold", 500, 2);

    expect(movie.tickets.length).toBe(1);
  });

  test("should remove ticket", () => {
    movie.addTicket("Avengers", "Gold", 500, 2);
    movie.removeTicket("Avengers");

    expect(movie.tickets.length).toBe(0);
  });

  test("should calculate total amount", () => {
    movie.addTicket("Avengers", "Gold", 500, 2);
    movie.addTicket("Batman", "Silver", 300, 1);

    expect(movie.calculateTotalAmount()).toBe(1300);
  });

  test("should apply offer", () => {
    movie.addTicket("Avengers", "Gold", 500, 2);

    expect(movie.applyOffer("MOVIE10")).toBe(900);
  });

  test("should calculate entertainment tax", () => {
    movie.addTicket("Avengers", "Gold", 500, 2);

    expect(movie.calculateEntertainmentTax(0.1)).toBe(100);
  });

  test("should complete final booking", () => {
    movie.addTicket("Avengers", "Gold", 500, 2);

    const result = movie.finalBooking("MOVIE10", 0.1);

    expect(result).toBe(990);

    expect(movie.tickets.length).toBe(0);
  });
});
