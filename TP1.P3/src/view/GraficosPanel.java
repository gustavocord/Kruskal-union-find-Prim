package view;

import java.awt.Color;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;


public class GraficosPanel extends JPanel {

	private DefaultCategoryDataset dataset;
	private JFreeChart chart;
	private ChartPanel chartPanel;
	public GraficosPanel() {

		// Fuente de Datos
		this.dataset = new DefaultCategoryDataset();
		this.dataset.setValue(0, "BFS", "");
		this.dataset.setValue(0, "Union-Find", "");
	

		// Creando el Grafico
		this.chart = ChartFactory.createBarChart
				("Kruskal","Implementacion", "Tiempo en NanoSeg", 
						this.dataset, PlotOrientation.VERTICAL, true,true, false);

		this.chart.setBackgroundPaint(Color.orange);
		this.chart.getTitle().setPaint(Color.black);

		//
		CategoryPlot p = chart.getCategoryPlot(); 
		p.setRangeGridlinePaint(Color.red); 
		p.setBackgroundPaint(Color.LIGHT_GRAY);

		//Cambiar colores de las barras 
		BarRenderer barRenderer = (BarRenderer) p.getRenderer(); 
		barRenderer.setBarPainter(new StandardBarPainter());
		barRenderer.setSeriesPaint(0, Color.BLACK); 
		barRenderer.setSeriesPaint(1, Color.GREEN); 
		barRenderer.setSeriesPaint(2, Color.YELLOW); 

		// Mostrar Grafico
		this.chartPanel = new ChartPanel(this.chart);
		this.add(this.chartPanel);
	}
	public void actualizarGrafica(long bfs,long unionFind) {
		this.dataset.setValue(bfs, "BFS", "");
		this.dataset.setValue(unionFind, "Union-Find", "");
		
	}
	public DefaultCategoryDataset getDataset() {
		return dataset;
	}
	public void setDataset(DefaultCategoryDataset dataset) {
		this.dataset = dataset;
	}
	public JFreeChart getChart() {
		return chart;
	}
	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}
	public ChartPanel getChartPanel() {
		return chartPanel;
	}
	public void setChartPanel(ChartPanel chartPanel) {
		this.chartPanel = chartPanel;
	}
}
