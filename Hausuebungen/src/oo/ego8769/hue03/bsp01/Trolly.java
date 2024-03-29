/**ego8769
 * 
 */
package oo.ego8769.hue03.bsp01;

import java.util.ArrayList;

import oo.ego8769.hue01.bsp02.Point;

/**
 * @author Elisabeth
 *
 */
public class Trolly {
	private int _idTrolly;
	private int _volumeMax;
	private int _weigthMax;
	private Point _posAct;
	private Point _posStart;
	private ArrayList<Product> _products;
	private DistributionCenter _myDistributionCenter;

	
	
	public Trolly(int idTrolly,int volumeMax, int weightMax, Point posStart, DistributionCenter myDistributionCenter) {
		_idTrolly= idTrolly;
		_posAct = new Point(posStart.getX(), posStart.getY()); // kopie von
																// originale
																// weil sontst
																// habe ich 2
																// referenzen
																// auf ein und
																// dem selben
																// Objekt
		_posStart = new Point(posStart.getX(), posStart.getY());
		_volumeMax = volumeMax;
		_weigthMax = weightMax;
		_products = new ArrayList<Product>();
		_myDistributionCenter = myDistributionCenter;
	}

	public boolean IsEmpty() {
		return _products.isEmpty();

	}
	public int get_idTrolly() {
		return _idTrolly;
	}

	public boolean IsFull() {
		if (IsEmpty() == true) {
			return false;
		} else if (_volumeMax >= currentVolume() && _weigthMax >= currentWeigth()) {
			return false;
		} else {
			return true;
		}
	}

	public int currentWeigth() {
		int summeWeigth = 0;
		for (int i = 0; i < _products.size(); i++) {
			summeWeigth = summeWeigth + _products.get(i).getWeight();
		}
		return summeWeigth;
	}

	public int currentVolume() {
		int summeVolumen = 0;
		for (int i = 0; i < _products.size(); i++) {
			summeVolumen = summeVolumen + _products.get(i).getVolume();
		}
		return summeVolumen;
	}

	public boolean moveLeft() {
		int tempX = _posAct.getX() - 1;

		if (_myDistributionCenter.isLegal(tempX, _posAct.getY())) {
			_posAct.setX(tempX);
			return true;
		}
		return false;
	}

	public boolean moveRight(){
		int tempX=_posAct.getX()+1;
		if (_myDistributionCenter.isLegal(tempX, _posAct.getY())){
			_posAct.setX(tempX);
			return true;
		}
		return false;
	}

	public boolean moveUp(){
		int tempY=_posAct.getY()+1;
		if (_myDistributionCenter.isLegal( _posAct.getX(), tempY)){
			_posAct.setY(tempY);
			return true;
		}
		return false;
	}
	
	public boolean moveDown(){
		int tempY=_posAct.getY()-1;
		if (_myDistributionCenter.isLegal( _posAct.getX(),tempY)){
			_posAct.setY(tempY);
			return true;
		}
		return false;
	}
	
	public boolean load(Product product) {
		if (canLoad(product) != true) {
			return false;
		} else {
			_products.add(product);
			return true;
		}
	}
		
		public boolean unload() {
			if (IsEmpty() == true) {
				return false;
			} else {
				_products.clear();
				return true;
			}

	}

	public boolean canLoad(Product product) {
		if ((_volumeMax >= currentVolume() + product.getVolume())
				&& (_weigthMax >= currentWeigth() + product.getWeight())) {
			return true;
		}
		return false;
	}
	
	

}
