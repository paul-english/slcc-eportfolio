// Utility for preventing 100% CPU usage in animation
if (!window.requestAnimationFrame) {
    window.requestAnimationFrame = (function () {
					return window.webkitRequestAnimationFrame ||
					    window.mozRequestAnimationFrame ||
					    window.oRequestAnimationFrame ||
					    window.msRequestAnimationFrame ||
					    function (callback,element) {
						window.setTimeout(callback, 1000 / 60); // Fallback timeout
					    };
				    })();
}
//console.log(requestAnimationFrame);

var superSize = function(el) {
    var w = window.innerWidth;
    var h = window.innerHeight;

    //console.log('superSize', w, h);

    el.setAttribute('width', w);
    el.setAttribute('height', h);
    el.getContext('2d').fillStyle = "#EDF7FC";
};

var PixelGenerator = function(canvas) {
    this.canvas = canvas;
    this.context = canvas.getContext('2d');
    this.context.fillStyle = "#EDF7FC";
    this.burst_amount = 5;
    this.gravity = 0.5;
    this.speed = 7;
    this.pixels = [];
    this.pixel_size = 5;
    this.animating = false;
    this.running = false;
    this.redraw = false;

};

PixelGenerator.prototype.burst = function(x, y) {
    //console.log('burst', x, y, this.burst_amount);

    
    for (var i = 0, len = this.burst_amount; i < len; i++) {
	var trajectory = Math.floor(Math.random() * 360);
	var pixel = [x, y, trajectory];
	
	this.pixels.push(pixel);
	//console.log('burst', this.pixels.length, pixel);
    }
};

PixelGenerator.prototype.start = function() {
    //console.log('start');
    this.animating = true;
    if (!this.running) this.draw();
};

PixelGenerator.prototype.stop = function() {
    //console.log('stop');
    this.animating = false;
};

PixelGenerator.prototype.renderStatic = function() {
    //console.log('renderStatic');
};

PixelGenerator.prototype.render = function() {
    //console.log('render', this.pixels.length, this.speed);

    if (this.pixels.length > 0) {
	
	// Clear the canvas for the new pixel positions
	this.context.clearRect(0, 0, this.canvas.width, this.canvas.height);

	for(var i = 0, len = this.pixels.length; i < len; i++) {

	    var pixel = this.pixels[i];

	    //console.log('pixel', i, pixel);

	    var x = pixel[0];
	    var y = pixel[1];

	    // Get x & y velocity or set it initially based on trajectory
	    var t = pixel[2];
	    var vx = pixel[3] || Math.cos(t) * this.speed;
	    var vy = pixel[4] || Math.sin(t) * this.speed;

	    if (x >= window.innerWidth || x <= 0 || y >= window.innerHeight || y <= 0) {

		// when the pixel is off screen remove it from the array
		var beginning = this.pixels.splice(0, i);
		this.pixels.shift();
		this.pixels = beginning.concat(this.pixels);

	    } else {
		
		// Perform the render using canvas contex
		this.context.fillRect(x, y, this.pixel_size, this.pixel_size);

		// Update pixel
		pixel[0] += vx;
		pixel[1] += vy;
		pixel[2] = t;
		pixel[3] = vx;
		pixel[4] = vy + this.gravity;

	    }

	}

    }

};

PixelGenerator.prototype.draw = function() {
    //console.log('draw', this.animating);

    if (this.animating) {
	//console.log('animating');
        this.running = true;
        try {
            if (this.redraw) {
                this.redraw = false;
                this.renderStatic();
            }
	    this.render();
        } catch (e) {
	    //console.log('render error', e);
        }

	//console.log('requestAnimationFrame', this);

	// Schedule the next animation frame while binding PixelGenerator as the scope
	var slow = false;
	if (slow) {
	    setTimeout(this.draw.bind(this), 250);
	} else {
            requestAnimationFrame(this.draw.bind(this));
	}

        this.running = false;
    }    
    
};

window.onload = function() {

    //console.log('?!');

    var body = document.querySelector('body');
    //console.log('body', body);

    // Create a canvas element & insert it into the background
    var canvas = document.createElement('canvas');
    superSize(canvas);
    canvas.setAttribute('style', 'z-index:-1000;position:fixed;left:0;top:0;');
    //console.log('canvas', canvas);

    body.appendChild(canvas);

    // Instantiate particle generator
    var generator = new PixelGenerator(canvas);
    generator.start();

    // Setup mouse listeners
    window.onmousemove = function(e) {
	var x = e.clientX;
	var y = e.clientY;

	//console.log('onmousemove', x, y);

	generator.burst(x, y);
    };

    // Resize canvas when changing window size
    window.onresize = function(e) {
	superSize(canvas);
    };

};
