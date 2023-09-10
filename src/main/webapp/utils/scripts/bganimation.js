

document.addEventListener('DOMContentLoaded', function() {

	particlesJS('particles-js', {
		"particles" : {
			"number" : {
				"value" : 60,
				"density" : {
					"enable" : true,
					"value_area" : 800
				}
			},
			"color" : {
				"value" : "#bfece3"//#ff97c6
			},
			"shape" : {
				"type" : "circle",
				"stroke" : {
					"width" : 0,
					"color" : "#362cff"
				},
				"polygon" : {
					"nb_sides" : 5
				},
				"image" : {
					"src" : "img/github.svg",
					"width" : 100,
					"height" : 100
				}
			},
			"opacity" : {
				"value" : 1,
				"random" : true,
				"anim" : {
					"enable" : true,
					"speed" : 1,
					"opacity_min" : 0,
					"sync" : true
				}
			},
			"size" : {
				"value" : 20,
				"random" : true,
				"anim" : {
					"enable" : false,
					"speed" : 4,
					"size_min" : 0.3,
					"sync" : false
				}
			},
			"line_linked" : {
				"enable" : false,
				"distance" : 150,
				"color" : "#ffffff",
				"opacity" : 0.4,
				"width" : 1
			},
			"move" : {
				"enable" : true,
				"speed" : 1,
				"direction" : "none",
				"random" : true,
				"straight" : false,
				"out_mode" : "out",
				"bounce" : false,
				"attract" : {
					"enable" : false,
					"rotateX" : 600,
					"rotateY" : 600
				}
			}
		},
		"interactivity" : {
			"detect_on" : "canvas",
			"events" : {
				"onhover" : {
					"enable" : true,
					"mode" : "bubble"
				},
				"onclick" : {
					"enable" : false,
					"mode" : "repulse"
				},
				"resize" : true
			},
			"modes" : {
				"grab" : {
					"distance" : 100,
					"line_linked" : {
						"opacity" : 0.8
					}
				},
				"bubble" : {
					"distance" : 250,
					"size" : 4,
					"duration" : 2,
					"opacity" : 1,
					"speed" : 3
				},
				"repulse" : {
					"distance" : 400,
					"duration" : 0.4
				},
				"push" : {
					"particles_nb" : 4
				},
				"remove" : {
					"particles_nb" : 2
				}
			}
		},
		"retina_detect" : true
	});

	/*
	  particleground(document.body, {
		  dotColor: '#d2d2d2',
		  lineColor: '#d2d2d2',
		  density: 20000,
	  });*/
	//var intro = document.getElementById('intro');
	//intro.style.marginTop = - intro.offsetHeight / 2 + 'px';
}, false);