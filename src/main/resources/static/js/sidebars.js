/*
  Copyright: MIT, Mark Otto, Jacob Thornton, and Bootstrap contributors
  Source: https://getbootstrap.com/docs/5.3/examples/
 */

/* global bootstrap: false */
(function () {
  'use strict'
  var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
  tooltipTriggerList.forEach(function (tooltipTriggerEl) {
    new bootstrap.Tooltip(tooltipTriggerEl)
  })
})()
