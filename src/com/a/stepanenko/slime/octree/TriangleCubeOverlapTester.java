package com.a.stepanenko.slime.octree;


public class TriangleCubeOverlapTester {

    public static final int X = 0;
    public static final int Y = 1;
    public static final int Z = 2;

    /********************************************************/
    /* AABB-triangle overlap test code                      */
    /* by Tomas Akenine-M�ller                             */
    /* Function: int triBoxOverlap(float boxcenter[3],      */
	/*          float boxhalfsize[3],float triverts[3][3]); */
	/* History:                                             */
	/*   2001-03-05: released the code in its first version */
	/*   2001-06-18: changed the order of the tests, faster */
	/*                                                      */
	/* Acknowledgement: Many thanks to Pierre Terdiman for  */
	/* suggestions and discussions on how to optimize code. */
	/* Thanks to David Hunt for finding a ">="-bug!         */

    /**
     * ***************************************************
     */

    private static float[] cross(float[] v1, float[] v2) {
        return new float[]{v1[1] * v2[2] - v1[2] * v2[1],
                v1[2] * v2[0] - v1[0] * v2[2],
                v1[0] * v2[1] - v1[1] * v2[0]};
    }

    private static float[] sub(float[] v1, float[] v2) {
        return new float[]{v1[0] - v2[0],
                v1[1] - v2[1],
                v1[2] - v2[2]};

    }

    private static float[] findMinMax(float v, float v1, float v2) {
        float[] result = new float[2];
        float min, max;
        min = v;
        max = v;

        if (v1 < min) min = v1;
        if (v1 > max) max = v1;
        if (v2 < min) min = v2;
        if (v2 > max) max = v2;

        result[0] = min;
        result[1] = max;

        return result;
    }

    //C++ TO JAVA CONVERTER NOTE: The following #define macro was replaced in-line:
    //ORIGINAL LINE: #define CROSS(dest,v1,v2) dest[0]=v1[1]*v2[com.test.com.some.tk]-v1[com.test.com.some.tk]*v2[1]; dest[1]=v1[com.test.com.some.tk]*v2[0]-v1[0]*v2[com.test.com.some.tk]; dest[com.test.com.some.tk]=v1[0]*v2[1]-v1[1]*v2[0];

    //C++ TO JAVA CONVERTER NOTE: The following #define macro was replaced in-line:
    //ORIGINAL LINE: #define DOT(v1,v2) (v1[0]*v2[0]+v1[1]*v2[1]+v1[com.test.com.some.tk]*v2[com.test.com.some.tk])

    //C++ TO JAVA CONVERTER NOTE: The following #define macro was replaced in-line:
    //ORIGINAL LINE: #define SUB(dest,v1,v2) dest[0]=v1[0]-v2[0]; dest[1]=v1[1]-v2[1]; dest[com.test.com.some.tk]=v1[com.test.com.some.tk]-v2[com.test.com.some.tk];

    //C++ TO JAVA CONVERTER NOTE: The following #define macro was replaced in-line:
    //ORIGINAL LINE: #define FINDMINMAX(x0,x1,x2,min,max) min = max = x0; if(x1<min) min=x1; if(x1>max) max=x1; if(x2<min) min=x2; if(x2>max) max=x2;

    private static int planeBoxOverlap(float[] normal, float[] vert, float[] maxbox) // -NJMP-
    {
        int q;
        float[] vmin = new float[3];
        float[] vmax = new float[3];
        float v;
        for (q = X; q <= Z; q++) {
            v = vert[q]; // -NJMP-
            if (normal[q] > 0.0f) {
                vmin[q] = -maxbox[q] - v; // -NJMP-
                vmax[q] = maxbox[q] - v; // -NJMP-
            } else {
                vmin[q] = maxbox[q] - v; // -NJMP-
                vmax[q] = -maxbox[q] - v; // -NJMP-
            }
        }
        if ((normal[0] * vmin[0] + normal[1] * vmin[1] + normal[2] * vmin[2]) > 0.0f) {
            return 0; // -NJMP-
        }
        if ((normal[0] * vmax[0] + normal[1] * vmax[1] + normal[2] * vmax[2]) >= 0.0f) {
            return 1; // -NJMP-
        }

        return 0;
    }


	/*======================== X-tests ========================*/
    //C++ TO JAVA CONVERTER NOTE: The following #define macro was replaced in-line:
    //ORIGINAL LINE: #define AXISTEST_X01(a, b, fa, fb) p0 = a*v0[Y] - b*v0[Z]; p2 = a*v2[Y] - b*v2[Z]; if(p0<p2) {min=p0; max=p2;} else {min=p2; max=p0;} rad = fa * boxhalfsize[Y] + fb * boxhalfsize[Z]; if(min>rad || max<-rad) return 0;

    //C++ TO JAVA CONVERTER NOTE: The following #define macro was replaced in-line:
    //ORIGINAL LINE: #define AXISTEST_X2(a, b, fa, fb) p0 = a*v0[Y] - b*v0[Z]; p1 = a*v1[Y] - b*v1[Z]; if(p0<p1) {min=p0; max=p1;} else {min=p1; max=p0;} rad = fa * boxhalfsize[Y] + fb * boxhalfsize[Z]; if(min>rad || max<-rad) return 0;

	/*======================== Y-tests ========================*/
    //C++ TO JAVA CONVERTER NOTE: The following #define macro was replaced in-line:
    //ORIGINAL LINE: #define AXISTEST_Y02(a, b, fa, fb) p0 = -a*v0[X] + b*v0[Z]; p2 = -a*v2[X] + b*v2[Z]; if(p0<p2) {min=p0; max=p2;} else {min=p2; max=p0;} rad = fa * boxhalfsize[X] + fb * boxhalfsize[Z]; if(min>rad || max<-rad) return 0;

    //C++ TO JAVA CONVERTER NOTE: The following #define macro was replaced in-line:
    //ORIGINAL LINE: #define AXISTEST_Y1(a, b, fa, fb) p0 = -a*v0[X] + b*v0[Z]; p1 = -a*v1[X] + b*v1[Z]; if(p0<p1) {min=p0; max=p1;} else {min=p1; max=p0;} rad = fa * boxhalfsize[X] + fb * boxhalfsize[Z]; if(min>rad || max<-rad) return 0;

	/*======================== Z-tests ========================*/

    //C++ TO JAVA CONVERTER NOTE: The following #define macro was replaced in-line:
    //ORIGINAL LINE: #define AXISTEST_Z12(a, b, fa, fb) p1 = a*v1[X] - b*v1[Y]; p2 = a*v2[X] - b*v2[Y]; if(p2<p1) {min=p2; max=p1;} else {min=p1; max=p2;} rad = fa * boxhalfsize[X] + fb * boxhalfsize[Y]; if(min>rad || max<-rad) return 0;

    //C++ TO JAVA CONVERTER NOTE: The following #define macro was replaced in-line:
    //ORIGINAL LINE: #define AXISTEST_Z0(a, b, fa, fb) p0 = a*v0[X] - b*v0[Y]; p1 = a*v1[X] - b*v1[Y]; if(p0<p1) {min=p0; max=p1;} else {min=p1; max=p0;} rad = fa * boxhalfsize[X] + fb * boxhalfsize[Y]; if(min>rad || max<-rad) return 0;


    public static boolean triBoxOverlap(float[] boxcenter, float[] boxhalfsize, float[][] triverts) {

	  /*    use separating axis theorem to test overlap between triangle and box        */
	  /*    need to test for overlap in these directions:                               */
	  /*    1) the {x,y,z}-directions (actually, since we use the AABB of the triangle  */
	  /*       we do not even need to test these)                                       */
	  /*    com.test.com.some.tk) normal of the triangle                                */
	  /*    3) crossproduct(edge from tri, {x,y,z}-directin)                            */
	  /*       this gives 3x3=9 more tests                                              */

        float[] v0 = new float[3];
        float[] v1 = new float[3];
        float[] v2 = new float[3];

        float min;
        float max;
        float p0;
        float p1;
        float p2;
        float rad;
        float fex;
        float fey;
        float fez;
        float[] normal = new float[3];
        float[] e0 = new float[3];
        float[] e1 = new float[3];
        float[] e2 = new float[3];

	   /* This is the fastest branch on Sun */
	   /* move everything so that the boxcenter is in (0,0,0) */
        v0 = sub(triverts[0], boxcenter);
        v1 = sub(triverts[1], boxcenter);
        v2 = sub(triverts[2], boxcenter);


	   /* compute triangle edges */
        // tri edge 0
        e0 = sub(v1, v0);
        // tri edge 1
        e1 = sub(v2, v1);
        // tri edge 2
        e2 = sub(v0, v2);

	   /* Bullet 3:  */
	   /*  test the 9 tests first (this was faster) */
        fex = Math.abs(e0[X]);
        fey = Math.abs(e0[Y]);
        fez = Math.abs(e0[Z]);
        p0 = e0[Z] * v0[Y] - e0[Y] * v0[Z];
        p2 = e0[Z] * v2[Y] - e0[Y] * v2[Z];

        if (p0 < p2) {
            min = p0;
            max = p2;
        } else {
            min = p2;
            max = p0;
        }
        rad = fez * boxhalfsize[Y] + fey * boxhalfsize[Z];
        if (min > rad || max < -rad) {
            return false;
        }
        p0 = -e0[Z] * v0[X] + e0[X] * v0[Z];
        p2 = -e0[Z] * v2[X] + e0[X] * v2[Z];
        if (p0 < p2) {
            min = p0;
            max = p2;
        } else {
            min = p2;
            max = p0;
        }
        rad = fez * boxhalfsize[X] + fex * boxhalfsize[Z];
        if (min > rad || max < -rad) {
            return false;
        }
        p1 = e0[Y] * v1[X] - e0[X] * v1[Y];
        p2 = e0[Y] * v2[X] - e0[X] * v2[Y];
        if (p2 < p1) {
            min = p2;
            max = p1;
        } else {
            min = p1;
            max = p2;
        }
        rad = fey * boxhalfsize[X] + fex * boxhalfsize[Y];
        if (min > rad || max < -rad) {
            return false;
        }

        fex = Math.abs(e1[X]);
        fey = Math.abs(e1[Y]);
        fez = Math.abs(e1[Z]);

        p0 = e1[Z] * v0[Y] - e1[Y] * v0[Z];
        p2 = e1[Z] * v2[Y] - e1[Y] * v2[Z];
        if (p0 < p2) {
            min = p0;
            max = p2;
        } else {
            min = p2;
            max = p0;
        }
        rad = fez * boxhalfsize[Y] + fey * boxhalfsize[Z];
        if (min > rad || max < -rad) {
            return false;
        }
        p0 = -e1[Z] * v0[X] + e1[X] * v0[Z];
        p2 = -e1[Z] * v2[X] + e1[X] * v2[Z];
        if (p0 < p2) {
            min = p0;
            max = p2;
        } else {
            min = p2;
            max = p0;
        }
        rad = fez * boxhalfsize[X] + fex * boxhalfsize[Z];
        if (min > rad || max < -rad) {
            return false;
        }
        p0 = e1[Y] * v0[X] - e1[X] * v0[Y];
        p1 = e1[Y] * v1[X] - e1[X] * v1[Y];
        if (p0 < p1) {
            min = p0;
            max = p1;
        } else {
            min = p1;
            max = p0;
        }
        rad = fey * boxhalfsize[X] + fex * boxhalfsize[Y];
        if (min > rad || max < -rad) {
            return false;
        }

        fex = Math.abs(e2[X]);
        fey = Math.abs(e2[Y]);
        fez = Math.abs(e2[Z]);

        p0 = e2[Z] * v0[Y] - e2[Y] * v0[Z];
        p1 = e2[Z] * v1[Y] - e2[Y] * v1[Z];
        if (p0 < p1) {
            min = p0;
            max = p1;
        } else {
            min = p1;
            max = p0;
        }
        rad = fez * boxhalfsize[Y] + fey * boxhalfsize[Z];
        if (min > rad || max < -rad) {
            return false;
        }
        p0 = -e2[Z] * v0[X] + e2[X] * v0[Z];
        p1 = -e2[Z] * v1[X] + e2[X] * v1[Z];
        if (p0 < p1) {
            min = p0;
            max = p1;
        } else {
            min = p1;
            max = p0;
        }
        rad = fez * boxhalfsize[X] + fex * boxhalfsize[Z];
        if (min > rad || max < -rad) {
            return false;
        }
        p1 = e2[Y] * v1[X] - e2[X] * v1[Y];
        p2 = e2[Y] * v2[X] - e2[X] * v2[Y];
        if (p2 < p1) {
            min = p2;
            max = p1;
        } else {
            min = p1;
            max = p2;
        }
        rad = fey * boxhalfsize[X] + fex * boxhalfsize[Y];
        if (min > rad || max < -rad) {
            return false;
        }

	   /* Bullet 1: */
	   /*  first test overlap in the {x,y,z}-directions */
	   /*  find min, max of the triangle each direction, and test for overlap in */
	   /*  that direction -- this is equivalent to testing a minimal AABB around */
	   /*  the triangle against the AABB */

	   /* test in X-direction */
        float[] temp = findMinMax(v0[X], v1[X], v2[X]);
        min = temp[0];
        max = temp[1];
        if (min > boxhalfsize[X] || max < -boxhalfsize[X]) {
            return false;
        }

	   /* test in Y-direction */

        temp = findMinMax(v0[Y], v1[Y], v2[Y]);
        min = temp[0];
        max = temp[1];

        if (min > boxhalfsize[Y] || max < -boxhalfsize[Y]) {
            return false;
        }

	   /* test in Z-direction */
        temp = findMinMax(v0[Z], v1[Z], v2[Z]);
        min = temp[0];
        max = temp[1];
        if (min > boxhalfsize[Z] || max < -boxhalfsize[Z]) {
            return false;
        }

	   /* Bullet test: */
	   /*  test if the box intersects the plane of the triangle */
	   /*  compute plane equation of triangle: normal*x+d=0 */
        normal = cross(e0, e1);
        return TriangleCubeOverlapTester.planeBoxOverlap(normal, v0, boxhalfsize) != 0;

    }

}