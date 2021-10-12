package view;

import java.awt.Color;
import java.awt.Shape;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

public class GraficosPanel extends JPanel {

	private DefaultCategoryDataset dataset;
	private JFreeChart chart;
	private ChartPanel chartPanel;
	public GraficosPanel() {

		// Fuente de Datos
		this.dataset = new DefaultCategoryDataset();
		this.dataset.setValue(0, "BFS", "");
		this.dataset.setValue(0, "Union-Find", "");
		this.dataset.setValue(0, "Union-Find V2", "");
		this.dataset.setValue(0, "BFS Optimizado", "");
		this.dataset.setValue(0, "Union-Find Optimizado", "");
		this.dataset.setValue(0, "Union-Find V2 Optimizado", "");

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
		barRenderer.setSeriesPaint(3, Color.CYAN); 
		barRenderer.setSeriesPaint(4, Color.RED); 
		barRenderer.setSeriesPaint(5, Color.BLUE); 

		// Mostrar Grafico
		this.chartPanel = new ChartPanel(this.chart);
		this.add(this.chartPanel);
	}
	public void actualizarGrafica(long bfs,long unionFindV1, long unionFindV2, long bfsOptimizado, long unionFindV1Optimizado, long unionFindV2Optimizado) {
		this.dataset.setValue(bfs, "BFS", "");
		this.dataset.setValue(unionFindV1, "Union-Find", "");
		this.dataset.setValue(unionFindV2, "Union-Find V2", "");
		this.dataset.setValue(bfsOptimizado, "BFS Optimizado", "");
		this.dataset.setValue(unionFindV1Optimizado, "Union-Find Optimizado", "");
		this.dataset.setValue(unionFindV2Optimizado, "Union-Find V2 Optimizado", "");
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
