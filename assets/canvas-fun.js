
//                      Tb.          Tb.
//                      :$$b.        $$$b.
//                      :$$$$b.      :$$$$b.
//                      :$$$$$$b     :$$$$$$b
//                       $$$$$$$b     $$$$$$$b
//                       $$$$$$$$b    :$$$$$$$b
//                       :$$$$$$$$b---^$$$$$$$$b
//                       :$$$$$$$$$b        ""^Tb
//                        $$$$$$$$$$b    __...__`.
//                        $$$$$$$$$$$b.g$$$$$$$$$pb
//                        $$$$$$$$$$$$$$$$$$$$$$$$$b
//                        $$$$$$$$$$$$$$$$$$$$$$$$$$b
//                        :$$$$$$$$$$$$$$$$$$$$$$$$$$;
//                        :$$$$$$$$$$$$$^T$$$$$$$$$$P;
//                        :$$$$$$$$$$$$$b  "^T$$$$P' :
//                        :$$$$$$$$$$$$$$b._.g$$$$$p.db
//                        :$$$$$$$$$$$$$$$$$$$$$$$$$$$$;
//                        :$$$$$$$$"""^^T$$$$$$$$$$$$P^;
//                        :$$$$$$$$       ""^^T$$$P^'  ;
//                        :$$$$$$$$    .'       `"     ;
//                        $$$$$$$$;   /                :
//                        $$$$$$$$;           .----,   :
//                        $$$$$$$$;         ,"          ;
//                        $$$$$$$$$p.                   |    "Activate interlocks!
//                       :$$$$$$$$$$$$p.                :    Dyna-therms connected.
//                       :$$$$$$$$$$$$$$$p.            .'    Infra-cells up;
//                       :$$$$$$$$$$$$$$$$$$p...___..-"      mega-thrusters are go!"
//                       $$$$$$$$$$$$$$$$$$$$$$$$$;
//    .db.               $$$$$$$$$$$$$$$$$$$$$$$$$$          ~ Iron Man ~
//   d$$$$bp.            $$$$$$$$$$$$$$$$$$$$$$$$$$;
//  d$$$$$$$$$$pp..__..gg$$$$$$$$$$$$$$$$$$$$$$$$$$$
// d$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$p._            .gp.
// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$p._.ggp._.d$$$$b

if (!window.requestAnimationFrame) {
    // How to prevent 100% CPU usage while animating
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

// Used when resizing the window
var superSize = function(el) {
    var w = window.innerWidth;
    var h = window.innerHeight;

    el.setAttribute('width', w);
    el.setAttribute('height', h);
    el.getContext('2d').fillStyle = "#CEE3ED";
};

// Core class for the pixel explosion animation
var PixelGenerator = function(canvas) {
    this.canvas = canvas;
    this.context = canvas.getContext('2d');
    this.context.fillStyle = "#CEE3ED";
    this.burst_amount = 5;
    this.gravity = 0.5;
    this.speed = 7;
    this.pixels = [];
    this.pixel_size = 5;
    this.animating = false;
    this.running = false;
};

// Create a group of pixels at the given x, y coordinate
PixelGenerator.prototype.burst = function(x, y) {
    
    for (var i = 0, len = this.burst_amount; i < len; i++) {
	var trajectory = Math.floor(Math.random() * 360);
	var pixel = [x, y, trajectory];
	
	this.pixels.push(pixel);
    }

};

// Begin animations
PixelGenerator.prototype.start = function() {
    this.animating = true;
    if (!this.running) this.draw();
};

// End animations
PixelGenerator.prototype.stop = function() {
    this.animating = false;
};

PixelGenerator.prototype.renderPixel = function(pixel) {

    var x = pixel[0];
    var y = pixel[1];

    // Perform the render using canvas contex
    this.context.fillRect(x, y, this.pixel_size, this.pixel_size);

};

PixelGenerator.prototype.movePixel = function(pixel) {

    // Get x & y velocity or set it initially based on trajectory
    var t = pixel[2];
    var vx = pixel[3] || Math.cos(t) * this.speed;
    var vy = pixel[4] || Math.sin(t) * this.speed;

    // Update pixel
    pixel[0] += vx;
    pixel[1] += vy;
    pixel[2] = t;
    pixel[3] = vx;
    pixel[4] = vy + this.gravity;

};

PixelGenerator.prototype.deletePixel = function(i) {

    var beginning = this.pixels.splice(0, i);
    this.pixels.shift();
    this.pixels = beginning.concat(this.pixels);

};

// Core rendering function
PixelGenerator.prototype.render = function() {

    if (this.pixels.length > 0) {
	
	// Clear the canvas for the new pixel positions
	this.context.clearRect(0, 0, this.canvas.width, this.canvas.height);

	for(var i = 0, len = this.pixels.length; i < len; i++) {

	    var pixel = this.pixels[i];
	    var x = pixel[0];
	    var y = pixel[1];

	    if (x >= window.innerWidth || x <= 0 || y >= window.innerHeight || y <= 0) {

		// when the pixel is off screen remove it from the array
		this.deletePixel(i);

	    } else {
		
		this.renderPixel(pixel);
		this.movePixel(pixel);

	    }

	}

    }

};

// Manage animation start/stop, and render the scene
PixelGenerator.prototype.draw = function() {

    if (this.animating) {

        this.running = true;
        try {
	    this.render();
        } catch (e) {
	    //console.log('render error', e);
        }

	// Schedule the next animation frame while binding PixelGenerator as the scope
	var slow = false; // for debugging
	if (slow) {
	    setTimeout(this.draw.bind(this), 250);
	} else {
            requestAnimationFrame(this.draw.bind(this));
	}

        this.running = false;
    }    
    
};

// Document setup
window.onload = function() {

    //console.log('?!');

    var body = document.querySelector('body');

    // Create a canvas element & insert it into the background
    var canvas = document.createElement('canvas');
    superSize(canvas);
    canvas.setAttribute('style', 'z-index:-1000;position:fixed;left:0;top:0;');

    body.appendChild(canvas);

    // Instantiate particle generator
    var generator = new PixelGenerator(canvas);
    generator.start();

    // Setup mouse listeners
    window.onmousemove = function(e) {
	var x = e.clientX;
	var y = e.clientY;

	generator.burst(x, y);
    };

    // Resize canvas when changing window size
    window.onresize = function(e) {
	superSize(canvas);
    };

};
