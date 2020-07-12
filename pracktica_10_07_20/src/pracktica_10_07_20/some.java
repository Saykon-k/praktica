package pracktica_10_07_20;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.BorderLayout;
import java.util.Dictionary;
import java.util.Hashtable;

public class some extends JFrame 
{
    private JLabel label;

    public some()
    {
        super("������ ������������� ��������� JSlider");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // ������� � ��������� ��������
        Dictionary <Integer, JLabel> labels = new Hashtable<Integer, JLabel>();
        labels.put(new Integer(0), new JLabel("<html><font color=red size=3>0"));
        labels.put(new Integer(60), new JLabel("<html><font color=gray size=3>30"));
        labels.put(new Integer(120), new JLabel("<html><font color=blue size=4>60"));
        labels.put(new Integer(180), new JLabel(new ImageIcon("images/star.png")));

        // �������� ������ ���������
        BoundedRangeModel model = new DefaultBoundedRangeModel(80, 0, 0, 200);

        // �������� ���������
        JSlider slider1 = new JSlider(model);
        JSlider slider2 = new JSlider(model);
        JSlider slider3 = new JSlider(0, 80, 20);
        JSlider slider4 = new JSlider(model);

        // ��������� �������� ���� ���������
        slider2.setOrientation(JSlider.VERTICAL);
        slider2.setMajorTickSpacing(50);
        slider2.setMinorTickSpacing(10);
        slider2.setPaintTicks(true);

        slider3.setPaintLabels(true);
        slider3.setMajorTickSpacing(10);

        slider4.setLabelTable(labels);
        slider4.setPaintLabels(true);

        label = new JLabel(getPercent(slider1.getValue()));
        // ������������ ���������
        slider1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                // ������ �������
                int value = ((JSlider)e.getSource()).getValue();
                label.setText(getPercent(value));
            }
        });
        // ���������� ��������� � ����������
        JPanel contents = new JPanel();
        contents.add(slider1);
        contents.add(slider2);
        contents.add(slider3);
        contents.add(slider4);
        getContentPane().add(contents);
        getContentPane().add(label, BorderLayout.SOUTH);
        // ����� ���� �� �����
        setSize(500, 300);
        setVisible(true);
    }
    private String getPercent(int value)
    {
        return "������ : " + (int)value/2 + "%";
    }
    public static void main(String[] args) {
        new some();
    }
}