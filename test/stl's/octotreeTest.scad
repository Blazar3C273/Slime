BcenterX=1;
BcenterY=0;
BcenterZ=6;
Blength=17;
Blength_2 = Blength/2;
MAX_DEPTH = 4;

cubes = [[5,6,0],[-5,6,0],[5,-6,0],[0,0,5]];

module surroudingBoxTest(){
	for (i = [0:3]) {
    translate([cubes[i][0],cubes[i][1],cubes[i][2]]) cube(5,center=true);
			}
    }
    
    *color("grey",0.1) translate([1,0,6]) cube(17,center=true);
    function checkRange(val,center,range) = val > (center - range) && val < (center + range); 
    function isInsideCube(x,y,z,cubeX,cubeY,cubeZ,size) = checkRange(x,cubeX,size) && checkRange(y,cubeY,size) && checkRange(z,cubeZ,size);  
	function isInside(x,y,z) = 
							 isInsideCube(x,y,z,cubes[0][0],cubes[0][1],cubes[0][2],5) ||
							 isInsideCube(x,y,z,cubes[1][0],cubes[1][1],cubes[1][2],5) || 
							 isInsideCube(x,y,z,cubes[2][0],cubes[2][1],cubes[2][2],5) || 
							 isInsideCube(x,y,z,cubes[3][0],cubes[3][1],cubes[3][2],5);

 module splittingPlanes(centerX,centerY,centerZ,length_2,depth) {                       
 	
    if(isInside(centerX,centerY,centerZ) ) {										
    																					
    %color("red",0.2){
    polyhedron(
  				points=[ [centerX-length_2,centerY-length_2,centerZ],[centerX-length_2,centerY+length_2,centerZ],[centerX+length_2,centerY+length_2,centerZ],[centerX+length_2,centerY-length_2,centerZ],
  		   				[centerX,centerY-length_2,centerZ-length_2],[centerX,centerY-length_2,centerZ+length_2],[centerX,centerY+length_2,centerZ+length_2],[centerX,centerY+length_2,centerZ-length_2],
  		   				[centerX-length_2,centerY,centerZ-length_2],[centerX-length_2,centerY,centerZ+length_2],[centerX+length_2,centerY,centerZ+length_2],[centerX+length_2,centerY,centerZ-length_2]],                                 
  				faces=[ [0,1,2],[2,3,0],[4,5,6],[6,7,4],[8,9,10],[10,11,8]]);
		}
	}
	if(depth >= 0) {
			next_length = length_2/2;
			next_depth = depth-1;
			params = [ 
						[centerX-next_length,centerY-next_length,centerZ+next_length], 
						[centerX+next_length,centerY-next_length,centerZ+next_length], 
						[centerX-next_length,centerY+next_length,centerZ+next_length], 
						[centerX+next_length,centerY+next_length,centerZ+next_length], 
						[centerX-next_length,centerY-next_length,centerZ-next_length], 
						[centerX+next_length,centerY-next_length,centerZ-next_length], 
						[centerX-next_length,centerY+next_length,centerZ-next_length], 
						[centerX+next_length,centerY+next_length,centerZ-next_length]];
						
			for (i = [0:7]) {
				if(isInside(params[i][0],params[i][1],params[i][2])) {
				splittingPlanes(params[i][0],params[i][1],params[i][2],next_length,next_depth);
				}	
			}
		}
    
 }   
    surroudingBoxTest();
    splittingPlanes(1,0,6,Blength_2,MAX_DEPTH);
    length = Blength_2/2;
    //splittingPlanes(1-length,0-length,6+length,length);
   /*{max=Dot{x=7.5, y=8.5, z=7.5}, min=Dot{x=-7.5, y=-8.5, z=-2.5}, edgeBegin=Dot{x=-7.5, y=-8.5, z=-2.5}, edgeEnd=Dot{x=9.5, y=8.5, z=14.5}, edgeLength=17.0}*/