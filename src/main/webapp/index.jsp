<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<body>

<!-- Guacamole -->
<script type="text/javascript"
        src="guacamole-common-js/all.min.js"></script>

<!-- Display -->
<div id="display"></div>

<!-- Init -->
<script type="text/javascript"> /* <![CDATA[ */

// Get display div from document
var display = document.getElementById("display");

// Instantiate client, using an HTTP tunnel for communications.
var guac = new Guacamole.Client(
    new Guacamole.HTTPTunnel("tunnel")
);

// Add client to display div
display.appendChild(guac.getDisplay().getElement());

// Error handler
guac.onerror = function (error) {
    alert(error);
};

// Connect
guac.connect();

// Disconnect on close
window.onunload = function () {
    guac.disconnect();
}

// Mouse
var mouse = new Guacamole.Mouse(guac.getDisplay().getElement());

mouse.onmousedown =
    mouse.onmouseup =
        mouse.onmousemove = function (mouseState) {
            guac.sendMouseState(mouseState);
        };

// Keyboard
var keyboard = new Guacamole.Keyboard(document);

keyboard.onkeydown = function (keysym) {
    guac.sendKeyEvent(1, keysym);
};

keyboard.onkeyup = function (keysym) {
    guac.sendKeyEvent(0, keysym);
};

/* ]]> */ </script>

</body>