const stars = document.querySelector(".stars");
const hill = document.querySelector(".hill");
const glow = document.querySelector(".glow");
const moon = document.querySelector(".moon");
const cloud1 = document.querySelector(".cloud1");
const cloud2 = document.querySelector(".cloud2");
const cloud3 = document.querySelector(".cloud3");
const heading = document.querySelector(".heading");
const container = document.querySelector(".container");
const tl = new TimelineLite();

tl.fromTo(container, 0.2, { opacity: 0 }, { opacity: 1 })
  .fromTo(
    stars,
    2.5,
    {
      y: "100%"
    },
    { y: "0%", ease: Power4.easeOut }
  )
  .fromTo(
    hill,
    1,
    {
      y: "100%"
    },
    { y: "0%", delay: -2 }
  )
  .fromTo(
    glow,
    2,
    {
      y: "100%"
    },
    { y: "0%", delay: -1, ease: Power4.easeOut }
  )
  .fromTo(
    moon,
    2,
    {
      y: "100%"
    },
    { y: "0%", delay: -0.7, ease: Power4.easeOut }
  )
  .fromTo(
    cloud1,
    2,
    {
      y: "100%"
    },
    { y: "0%", delay: -1.8, ease: Power4.easeOut }
  )
  .fromTo(
    cloud2,
    2,
    {
      y: "100%"
    },
    { y: "0%", delay: -1.5, ease: Power4.easeOut }
  )
  .fromTo(
    cloud3,
    2,
    {
      y: "100%"
    },
    { y: "0%", delay: -1.5, ease: Power4.easeOut }
  )
  .fromTo(
    heading,
    3,
    {
      opacity: 0
    },
    { opacity: 1, delay: -1, ease: Power2.easeOut }
  );
