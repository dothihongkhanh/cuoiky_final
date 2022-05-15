/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import VIEW.ThongKe_JPanelFrom;
import bean.DanhMucBean;
import VIEW.QL_SanPham_JPanelForm;
import VIEW.QL_HoaDon_JPanelForm;
import VIEW.QL_KhachHang_JPanelForm;
import VIEW.QL_KhuyenMai_JPanelForm;
import VIEW.TrangChu_JPanelForm;
import VIEW.QL_NhanVien_JPanelForm;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */
public class ChuyenManHinhController {

    private JPanel root;
    private String kinSelected = "";

    private List<DanhMucBean> listItem = null;

    public ChuyenManHinhController(JPanel jpnroot) {
        this.root = jpnroot;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kinSelected = "TrangChu";

        jpnItem.setBackground(new Color(96, 100, 191));
        jlbItem.setBackground(new Color(96, 100, 191));

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChu_JPanelForm());
        root.validate();
        root.repaint();
    }

    public void setEvent(List<DanhMucBean> listItem) {
        this.listItem = listItem;

        for (DanhMucBean item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {

            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                
                case "TrangChu":
                    node = new TrangChu_JPanelForm();
                    break;
                case "QuanLySanPham":
                    node = new QL_SanPham_JPanelForm();
                    break;
                case "QuanLyKhuyenMai":
                    node = new QL_KhuyenMai_JPanelForm();
                    break;
                case "QuanLyNhanVien":
                    node = new QL_NhanVien_JPanelForm();
                    break;
                case "QuanLyKhachHang":
                    node = new QL_KhachHang_JPanelForm();
                    break;
                case "QuanLyHoaDon":
                    node = new QL_HoaDon_JPanelForm();
                    break;
                 case "ThongKe":
                    node = new ThongKe_JPanelFrom();
                    break;

            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kinSelected = kind;
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));

        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(96, 100, 191));//xanh duong
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kinSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(51,204,0));
                jlbItem.setBackground(new Color(51,204,0));
            }
        }

        private void setChangeBackground(String kind) {
            for (DanhMucBean item : listItem) {
                if (item.getKind().equalsIgnoreCase(kind)) {
                    item.getJlb().setBackground(new Color(96, 100, 191));
                    item.getJpn().setBackground(new Color(96, 100, 191));
                } else {
                    item.getJlb().setBackground(new Color(51,204,0));
                    item.getJpn().setBackground(new Color(51,204,0));
                }
            }
        }
    }
}
