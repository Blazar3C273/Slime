W=1.25;
L=2.0;
a=0.4;
b=0.4;
t=0.6;
module pin(){
    difference(){
    cube([W,b,t],center = true);
    #translate([-W/2,-b/2,-t/2+0.05]) cube([W,b-0.05,t-0.1]);    
    }
}
module smd0805(){
    cube([W,L-0.1,t-0.1],center=true);
    mirror([0,1,0])
    color("grey")translate([0,L/2-b/2,0]) pin();
    color("grey")translate([0,L/2-b/2,0]) pin();
    }
    
    smd0805();