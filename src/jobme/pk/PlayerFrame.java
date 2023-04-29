/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobme.pk;

import jaco.mp3.player.MP3Player;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Paths;
import java.sql.Time;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class PlayerFrame extends javax.swing.JFrame {

    // Define MP3Player Class From JACO MP3Player Lib
    MP3Player player;
    // Define File For Song
    File songFile;
    // Define Current Directory Like If We Use JFileChooser then where it statys.
    String currentDirectory = "home.user"; // I am using home.user this will call file chooser in user documents.
    // Here I define currentPath of the running app class
    String currentPath;
    // This String Will Be For Image Name or Path
    String imagePath;
    // We need to set app title as string
    String appName = "VK MUSIC - (MP3 Player)";
    private Timer timer;
    // Now Check If Repeat Button is Enabled or not
    boolean repeat = false;
    
    // Here I am making a boolean for windowCollapsed
    boolean windowCollapsed = false;
    
    // Here I need to define mouse x and y for to get mouse position on screen.
    int xMouse, yMouse;
    

    public PlayerFrame() {
        initComponents();
        // Set App Title Here
        appTitle.setText(appName);
        
        // Here I am going to set a default song file. It's not necessary.
        songFile = new File("C:\\Users\\dell\\Desktop\\Javafinalproject\\songs\\Shape Of You.mp3");
        
        // Now make a string to get file name
        String fileName = songFile.getName();
        // Here set our song name label with this name
        songNameDisplay.setText(fileName);
        
        // Add our method to player variable
        player = mp3Player();
        // Now add song to player as playlist.
        player.addToPlayList(songFile);
        
        // Here get current path and images path in strings
        currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
        imagePath = "\\images";
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        appTitle = new javax.swing.JLabel();
        quitBtn = new javax.swing.JLabel();
        settingsBtn = new javax.swing.JLabel();
        controlPanel = new javax.swing.JPanel();
        songNameMainPanel = new javax.swing.JPanel();
        songNameSubPanel = new javax.swing.JPanel();
        songNameDisplay = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        muteBtn1 = new javax.swing.JLabel();
        volumeFullBtn = new javax.swing.JLabel();
        volumeUpBtn = new javax.swing.JLabel();
        volumeDownBtn = new javax.swing.JLabel();
        openBtn = new javax.swing.JLabel();
        stopBtn = new javax.swing.JLabel();
        playBtn = new javax.swing.JLabel();
        pauseBtn = new javax.swing.JLabel();
        repeatBtn = new javax.swing.JLabel();
        controlPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(0, 0, 0));

        headerPanel.setBackground(new java.awt.Color(0, 0, 0));

        appTitle.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        appTitle.setForeground(new java.awt.Color(0, 204, 204));
        appTitle.setText("APP TITLE");
        appTitle.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                appTitleMouseDragged(evt);
            }
        });
        appTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appTitleMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                appTitleMousePressed(evt);
            }
        });

        quitBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jobme/pk/images/quit.png"))); // NOI18N
        quitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quitBtnMouseClicked(evt);
            }
        });

        settingsBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        settingsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jobme/pk/images/settings.png"))); // NOI18N
        settingsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingsBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(appTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(settingsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(quitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(settingsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(appTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        controlPanel.setBackground(new java.awt.Color(0, 0, 0));

        songNameMainPanel.setBackground(new java.awt.Color(0, 0, 0));

        songNameSubPanel.setBackground(new java.awt.Color(7, 63, 86));
        songNameSubPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 202, 237), 1, true));

        songNameDisplay.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        songNameDisplay.setForeground(new java.awt.Color(34, 202, 237));
        songNameDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        songNameDisplay.setText("PLAYING");

        javax.swing.GroupLayout songNameSubPanelLayout = new javax.swing.GroupLayout(songNameSubPanel);
        songNameSubPanel.setLayout(songNameSubPanelLayout);
        songNameSubPanelLayout.setHorizontalGroup(
            songNameSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(songNameDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        songNameSubPanelLayout.setVerticalGroup(
            songNameSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(songNameDisplay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout songNameMainPanelLayout = new javax.swing.GroupLayout(songNameMainPanel);
        songNameMainPanel.setLayout(songNameMainPanelLayout);
        songNameMainPanelLayout.setHorizontalGroup(
            songNameMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(songNameSubPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        songNameMainPanelLayout.setVerticalGroup(
            songNameMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, songNameMainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(songNameSubPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jobme/pk/images/picmix.com_2066353.gif"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Lyrics");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(controlPanelLayout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(251, 251, 251)
                        .addComponent(jButton1)
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addComponent(songNameMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(controlPanelLayout.createSequentialGroup()
                        .addContainerGap(210, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(43, 43, 43))
                    .addGroup(controlPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(songNameMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        muteBtn1.setBackground(new java.awt.Color(255, 255, 255));
        muteBtn1.setForeground(new java.awt.Color(255, 0, 51));
        muteBtn1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        muteBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jobme/pk/images/mute.png"))); // NOI18N
        muteBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                muteBtn1MouseClicked(evt);
            }
        });

        volumeFullBtn.setBackground(new java.awt.Color(255, 255, 255));
        volumeFullBtn.setForeground(new java.awt.Color(255, 0, 51));
        volumeFullBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        volumeFullBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jobme/pk/images/volume_full.png"))); // NOI18N
        volumeFullBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                volumeFullBtnMouseClicked(evt);
            }
        });

        volumeUpBtn.setBackground(new java.awt.Color(255, 255, 255));
        volumeUpBtn.setForeground(new java.awt.Color(255, 0, 51));
        volumeUpBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        volumeUpBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jobme/pk/images/volume_up.png"))); // NOI18N
        volumeUpBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                volumeUpBtnMouseClicked(evt);
            }
        });

        volumeDownBtn.setBackground(new java.awt.Color(255, 255, 255));
        volumeDownBtn.setForeground(new java.awt.Color(255, 0, 51));
        volumeDownBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        volumeDownBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jobme/pk/images/volume_down.png"))); // NOI18N
        volumeDownBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                volumeDownBtnMouseClicked(evt);
            }
        });

        openBtn.setBackground(new java.awt.Color(255, 255, 255));
        openBtn.setForeground(new java.awt.Color(255, 0, 51));
        openBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        openBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jobme/pk/images/open.png"))); // NOI18N
        openBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openBtnMouseClicked(evt);
            }
        });

        stopBtn.setBackground(new java.awt.Color(255, 255, 255));
        stopBtn.setForeground(new java.awt.Color(255, 0, 51));
        stopBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stopBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jobme/pk/images/stop.png"))); // NOI18N
        stopBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stopBtnMouseClicked(evt);
            }
        });

        playBtn.setBackground(new java.awt.Color(255, 255, 255));
        playBtn.setForeground(new java.awt.Color(255, 0, 51));
        playBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jobme/pk/images/play.png"))); // NOI18N
        playBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playBtnMouseClicked(evt);
            }
        });

        pauseBtn.setBackground(new java.awt.Color(255, 255, 255));
        pauseBtn.setForeground(new java.awt.Color(255, 0, 51));
        pauseBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pauseBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jobme/pk/images/pause.png"))); // NOI18N
        pauseBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pauseBtnMouseClicked(evt);
            }
        });

        repeatBtn.setBackground(new java.awt.Color(255, 255, 255));
        repeatBtn.setForeground(new java.awt.Color(255, 0, 51));
        repeatBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        repeatBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jobme/pk/images/repeat.png"))); // NOI18N
        repeatBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                repeatBtnMouseClicked(evt);
            }
        });

        controlPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setForeground(new java.awt.Color(255, 0, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout controlPanel1Layout = new javax.swing.GroupLayout(controlPanel1);
        controlPanel1.setLayout(controlPanel1Layout);
        controlPanel1Layout.setHorizontalGroup(
            controlPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanel1Layout.createSequentialGroup()
                .addGap(580, 580, 580)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        controlPanel1Layout.setVerticalGroup(
            controlPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(repeatBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pauseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(playBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stopBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(openBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(volumeDownBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(volumeUpBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(volumeFullBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(muteBtn1)
                .addGap(167, 167, 167))
            .addComponent(controlPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(controlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(controlPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(openBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(muteBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(volumeFullBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(volumeUpBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(volumeDownBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stopBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pauseBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(repeatBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void playBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playBtnMouseClicked
        // TODO add your handling code here:
        
       
        // Initialize the slider and timer
        //jSlider2 slider = new jSlider2(0, songDuration);
        

// Start the timer when the song starts playing
         player.play();
       
// Stop the timer when the song stops
       // stopSong();
        //timer.stop();

    }//GEN-LAST:event_playBtnMouseClicked

    private void stopBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopBtnMouseClicked
        // TODO add your handling code here:
        player.stop();
    }//GEN-LAST:event_stopBtnMouseClicked

    private void pauseBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pauseBtnMouseClicked
        // TODO add your handling code here:
        player.pause();
    }//GEN-LAST:event_pauseBtnMouseClicked

    private void repeatBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repeatBtnMouseClicked
        // TODO add your handling code here:
        if(repeat == false){
            repeat = true;
            player.setRepeat(repeat);
            
            String image = currentPath+imagePath+"\\repeat_enabled.png";
            repeatBtn.setIcon(new ImageIcon(image));
        }else if(repeat == true){
            repeat = false;
            player.setRepeat(repeat);
            
            String image = currentPath+imagePath+"\\repeat.png";
            repeatBtn.setIcon(new ImageIcon(image));            
        }
    }//GEN-LAST:event_repeatBtnMouseClicked

    private void appTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appTitleMousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_appTitleMousePressed

    private void appTitleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appTitleMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_appTitleMouseDragged

    private void quitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quitBtnMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_quitBtnMouseClicked

    private void settingsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsBtnMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Your settings dilog will be popup here!");
    }//GEN-LAST:event_settingsBtnMouseClicked

    private void openBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openBtnMouseClicked
        // TODO add your handling code here:
        JFileChooser openFileChooser = new JFileChooser(currentDirectory);
        openFileChooser.setFileFilter(new FileTypeFilter(".mp3", "Open MP3 Files Only!"));
        int result = openFileChooser.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            songFile = openFileChooser.getSelectedFile();
            player.addToPlayList(songFile);
            player.skipForward();
            currentDirectory = songFile.getAbsolutePath();
            songNameDisplay.setText("Playing Now... | " + songFile.getName());
        }
    }//GEN-LAST:event_openBtnMouseClicked

    private void appTitleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appTitleMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2){
            if(windowCollapsed == false){
                windowCollapsed = true;
                this.setSize(new Dimension(this.getSize().width, 50));
                
                appTitle.setFont(new Font("Nirmala UI", 0, 12));
                appTitle.setText("Playing Now... | " + songFile.getName());
            }else if(windowCollapsed == true){
                windowCollapsed = false;
                this.setSize(new Dimension(this.getSize().width, 250));
                
                appTitle.setFont(new Font("Nirmala UI", 0, 18));
                appTitle.setText(appName);
            }
        }
    }//GEN-LAST:event_appTitleMouseClicked

    private void volumeDownBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volumeDownBtnMouseClicked
        // TODO add your handling code here:
        volumeDownControl(0.1);
    }//GEN-LAST:event_volumeDownBtnMouseClicked

    private void volumeUpBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volumeUpBtnMouseClicked
        // TODO add your handling code here:
        volumeUpControl(0.1);
    }//GEN-LAST:event_volumeUpBtnMouseClicked

    private void volumeFullBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volumeFullBtnMouseClicked
        // TODO add your handling code here:
        volumeControl(1.0);
    }//GEN-LAST:event_volumeFullBtnMouseClicked

    private void muteBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_muteBtn1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_muteBtn1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        LyricFrame obj=new LyricFrame();
        if(songNameDisplay.getText().equals("Shape Of You.mp3")){
        obj.jTextArea1.setText("The club isn't the best place to find a lover\n" +
"So the bar is where I go\n" +
"Me and my friends at the table doing shots\n" +
"Drinking fast and then we talk slow\n" +
"Come over and start up a conversation with just me\n" +
"And trust me I'll give it a chance now\n" +
"Take my hand, stop, put Van the Man on the jukebox\n" +
"And then we start to dance, and now I'm singing like\n" +
"Girl, you know I want your love\n" +
"Your love was handmade for somebody like me\n" +
"Come on now, follow my lead\n" +
"I may be crazy, don't mind me\n" +
"Say, boy, let's not talk too much\n" +
"Grab on my waist and put that body on me\n" +
"Come on now, follow my lead\n" +
"Come, come on now, follow my lead\n" +
"I'm in love with the shape of you\n" +
"We push and pull like a magnet do\n" +
"Although my heart is falling too\n" +
"I'm in love with your body\n" +
"Last night you were in my room\n" +
"And now my bedsheets smell like you\n" +
"Every day discovering something brand new\n" +
"I'm in love with your body\n" +
"(Oh-I-oh-I-oh-I-oh-I)\n" +
"I'm in love with your body\n" +
"(Oh-I-oh-I-oh-I-oh-I)\n" +
"I'm in love with your body\n" +
"(Oh-I-oh-I-oh-I-oh-I)\n" +
"I'm in love with your body\n" +
"Every day discovering something brand new\n" +
"I'm in love with the shape of you\n" +
"One week in we let the story begin\n" +
"We're going out on our first date\n" +
"You and me are thrifty, so go all you can eat\n" +
"Fill up your bag and I fill up a plate\n" +
"We talk for hours and hours about the sweet and the sour\n" +
"And how your family is doing okay\n" +
"Leave and get in a taxi, then kiss in the backseat\n" +
"Tell the driver make the radio play, and I'm singing like\n" +
"Girl, you know I want your love\n" +
"Your love was handmade for somebody like me\n" +
"Come on now, follow my lead\n" +
"I may be crazy, don't mind me\n" +
"Say, boy, let's not talk too much\n" +
"Grab on my waist and put that body on me\n" +
"Come on now, follow my lead\n" +
"Come, come on now, follow my lead\n" +
"I'm in love with the shape of you\n" +
"We push and pull like a magnet do\n" +
"Although my heart is falling too\n" +
"I'm in love with your body\n" +
"Last night you were in my room\n" +
"And now my bedsheets smell like you\n" +
"Every day discovering something brand new\n" +
"I'm in love with your body\n" +
"(Oh-I-oh-I-oh-I-oh-I)\n" +
"I'm in love with your body\n" +
"(Oh-I-oh-I-oh-I-oh-I)\n" +
"I'm in love with your body\n" +
"(Oh-I-oh-I-oh-I-oh-I)\n" +
"I'm in love with your body\n" +
"Every day discovering something brand new\n" +
"I'm in love with the shape of you\n" +
"Come on, be my baby, come on\n" +
"Come on, be my baby, come on\n" +
"Come on, be my baby, come on\n" +
"Come on, be my baby, come on\n" +
"Come on, be my baby, come on\n" +
"Come on, be my baby, come on\n" +
"Come on, be my baby, come on\n" +
"Come on, be my baby, come on\n" +
"I'm in love with the shape of you\n" +
"We push and pull like a magnet do\n" +
"Although my heart is falling too\n" +
"I'm in love with your body\n" +
"Last night you were in my room\n" +
"And now my bedsheets smell like you\n" +
"Every day discovering something brand new\n" +
"I'm in love with your body\n" +
"Come on, be my baby, come on\n" +
"Come on (I'm in love with your body), be my baby, come on\n" +
"Come on, be my baby, come on\n" +
"Come on (I'm in love with your body), be my baby, come on\n" +
"Come on, be my baby, come on\n" +
"Come on (I'm in love with your body), be my baby, come on\n" +
"Every day discovering something brand new\n" +
"I'm in love with the shape of you");
    }//GEN-LAST:event_jButton1ActionPerformed
   
if(songNameDisplay.getText().equals("Playing Now... | Perfect.mp3")){
        obj.jTextArea1.setText("I found a love, for me\n" +
"Darling, just dive right in and follow my lead\n" +
"Well, I found a girl, beautiful and sweet\n" +
"Oh, I never knew you were the someone waiting for me\n" +
"'Cause we were just kids when we fell in love\n" +
"Not knowing what it was\n" +
"I will not give you up this time\n" +
"But darling, just kiss me slow\n" +
"Your heart is all I own\n" +
"And in your eyes, you're holding mine\n" +
"Baby, I'm dancing in the dark\n" +
"With you between my arms\n" +
"Barefoot on the grass\n" +
"Listening to our favourite song\n" +
"When you said you looked a mess\n" +
"I whispered underneath my breath\n" +
"But you heard it\n" +
"Darling, you look perfect tonight\n" +
"Well, I found a woman, stronger than anyone I know\n" +
"She shares my dreams, I hope that someday I'll share her home\n" +
"I found a lover, to carry more than just my secrets\n" +
"To carry love, to carry children of our own\n" +
"We are still kids, but we're so in love\n" +
"Fighting against all odds\n" +
"I know we'll be alright this time\n" +
"Darling, just hold my hand\n" +
"Be my girl, I'll be your man\n" +
"I see my future in your eyes\n" +
"Baby, I'm dancing in the dark\n" +
"With you between my arms\n" +
"Barefoot on the grass\n" +
"Listening to our favorite song\n" +
"When I saw you in that dress, looking so beautiful\n" +
"I don't deserve this\n" +
"Darling, you look perfect tonight\n" +
"Baby, I'm dancing in the dark\n" +
"With you between my arms\n" +
"Barefoot on the grass\n" +
"Listening to our favorite song\n" +
"I have faith in what I see\n" +
"Now I know I have met an angel in person\n" +
"And she looks perfect\n" +
"I don't deserve this\n" +
"You look perfect tonight");
    } 
    if(songNameDisplay.getText().equals("Playing Now... | Senorita.mp3")){
        obj.jTextArea1.setText("I love it when you call me señorita\n" +
"I wish I could pretend I didn't need ya\n" +
"But every touch is ooh, la-la-la\n" +
"It's true, la-la-la\n" +
"Ooh, I should be running\n" +
"Ooh, you keep me coming for ya\n" +
"Land in Miami\n" +
"The air was hot from summer rain\n" +
"Sweat dripping off me\n" +
"Before I even knew her name, la-la-la\n" +
"It felt like ooh, la-la-la\n" +
"Yeah, no\n" +
"Sapphire moonlight\n" +
"We danced for hours in the sand\n" +
"Tequila sunrise\n" +
"Her body fit right in my hands, la-la-la\n" +
"It felt like ooh, la-la-la, yeah\n" +
"I love it when you call me señorita\n" +
"I wish I could pretend I didn't need ya\n" +
"But every touch is ooh, la-la-la\n" +
"It's true, la-la-la\n" +
"Ooh, I should be running\n" +
"Ooh, you know I love it when you call me señorita\n" +
"I wish it wasn't so damn hard to leave ya\n" +
"But every touch is ooh, la-la-la\n" +
"It's true, la-la-la\n" +
"Ooh, I should be running\n" +
"Ooh, you keep me coming for ya\n" +
"Locked in the hotel\n" +
"There's just some things that never change\n" +
"You say we're just friends\n" +
"But friends don't know the way you taste, la-la-la\n" +
"'Cause you know it's been a long time coming\n" +
"Don't you let me fall, oh\n" +
"Ooh, when your lips undress me\n" +
"Hooked on your tongue\n" +
"Ooh, love, your kiss is deadly\n" +
"Don't stop\n" +
"I love it when you call me señorita\n" +
"I wish I could pretend I didn't need ya\n" +
"But every touch is ooh, la-la-la\n" +
"It's true, la-la-la\n" +
"Ooh, I should be running\n" +
"Ooh, you know I love it when you call me señorita\n" +
"I wish it wasn't so damn hard to leave ya\n" +
"But every touch is ooh, la-la-la\n" +
"It's true, la-la-la (true, la-la)\n" +
"Ooh, I should be running\n" +
"Ooh, you keep me coming for ya\n" +
"All along I've been coming for ya (for ya)\n" +
"And I hope it meant something to ya (ooh)\n" +
"Call my name, I'll be coming for ya\n" +
"Coming for ya, coming for ya, coming for ya\n" +
"For ya\n" +
"For ya (oh, she loves it when I call)\n" +
"For ya\n" +
"Ooh, I should be running\n" +
"Ooh, you keep me coming for ya");
    } 
    if(songNameDisplay.getText().equals("Playing Now... | Dendelions.mp3")){
        obj.jTextArea1.setText("Maybe, it's the way you say my name\n" +
"Maybe, it's the way you play your game\n" +
"But it's so good, I've never known anybody like you\n" +
"But it's so good, I've never dreamed of nobody like you\n" +
"And I've heard of a love that comes once in a lifetime\n" +
"And I'm pretty sure that you are that love of mine\n" +
"'Cause I'm in a field of dandelions\n" +
"Wishing on every one that you'll be mine, mine\n" +
"And I see forever in your eyes\n" +
"I feel okay when I see you smile, smile\n" +
"Wishing on dandelions all of the time\n" +
"Praying to God that one day you'll be mine\n" +
"Wishing on dandelions all of the time, all of the time\n" +
"I think that you are the one for me\n" +
"'Cause it gets so hard to breathe\n" +
"When you're looking at me, I've never felt so alive and free\n" +
"When you're looking at me, I've never felt so happy\n" +
"And I've heard of a love that comes once in a lifetime\n" +
"And I'm pretty sure that you are that love of mine\n" +
"'Cause I'm in a field of dandelions\n" +
"Wishing on every one that you'll be mine, mine\n" +
"And I see forever in your eyes\n" +
"I feel okay, when I see you smile, smile\n" +
"Wishing on dandelions all of the time\n" +
"Praying to God that one day you'll be mine\n" +
"Wishing on dandelions all of the time, all of the time\n" +
"Dandelion, into the wind you go\n" +
"Won't you let my darling know?\n" +
"Dandelion, into the wind you go\n" +
"Won't you let my darling know that?\n" +
"I'm in a field of dandelions\n" +
"Wishing on every one that you'll be mine, mine\n" +
"And I see forever in your eyes\n" +
"I feel okay when I see you smile, smile\n" +
"Wishing on dandelions all of the time\n" +
"Praying to God that one day you'll be mine\n" +
"Wishing on dandelions all of the time, all of the time\n" +
"I'm in a field of dandelions\n" +
"Wishing on every one that you'll be mine, mine");
    } 
        obj.setVisible(true);}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlayerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlayerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appTitle;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JPanel controlPanel1;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel muteBtn1;
    private javax.swing.JLabel openBtn;
    private javax.swing.JLabel pauseBtn;
    private javax.swing.JLabel playBtn;
    private javax.swing.JLabel quitBtn;
    private javax.swing.JLabel repeatBtn;
    private javax.swing.JLabel settingsBtn;
    private javax.swing.JLabel songNameDisplay;
    private javax.swing.JPanel songNameMainPanel;
    private javax.swing.JPanel songNameSubPanel;
    private javax.swing.JLabel stopBtn;
    private javax.swing.JLabel volumeDownBtn;
    private javax.swing.JLabel volumeFullBtn;
    private javax.swing.JLabel volumeUpBtn;
    // End of variables declaration//GEN-END:variables
    
    // I am going to create a custom MP3Player Method
    private MP3Player mp3Player(){
        MP3Player mp3Player = new MP3Player();
        return mp3Player;
    }
    
    // Let's Set Volume Down Method It's not necessary to remeber this code.
    private void volumeDownControl(Double valueToPlusMinus){
        // Get Mixer Information From AudioSystem
        Mixer.Info[] mixers = AudioSystem.getMixerInfo();
        // Now use a for loop to list all mixers
        for(Mixer.Info mixerInfo : mixers){
            // Get Mixer
            Mixer mixer = AudioSystem.getMixer(mixerInfo);
            // Now Get Target Line
            Line.Info[] lineInfos = mixer.getTargetLineInfo();
            // Here again use for loop to list lines
            for(Line.Info lineInfo : lineInfos){
                // Make a null line
                Line line = null;
                // Make a boolean as opened
                boolean opened = true;
                // Now use try exception for opening a line
                try{
                    line = mixer.getLine(lineInfo);
                    opened = line.isOpen() || line instanceof Clip;
                    // Now Check If Line Is not Opened
                    if(!opened){
                        // Open Line
                        line.open();
                    }
                    // Make a float control
                    FloatControl volControl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                    // Get Current Volume Now
                    float currentVolume = volControl.getValue();
                    // Make a temp double variable and store valuePlusMinus
                    Double volumeToCut = valueToPlusMinus;
                    // Make a float and calculate the addition or subtraction in volume
                    float changedCalc = (float) ((float)currentVolume-(double)volumeToCut);
                    // Now Set This Changed Value Into Volume Line.
                    volControl.setValue(changedCalc);
                    
                }catch (LineUnavailableException lineException){
                }catch (IllegalArgumentException illException){
                }finally{
                    // Close Line If it opened
                    if(line != null && !opened){
                        line.close();
                    }
                }
            }
        }
    }
    
    // Let's Set Volume Up Method It's not necessary to remeber this code.
    private void volumeUpControl(Double valueToPlusMinus){
        // Get Mixer Information From AudioSystem
        Mixer.Info[] mixers = AudioSystem.getMixerInfo();
        // Now use a for loop to list all mixers
        for(Mixer.Info mixerInfo : mixers){
            // Get Mixer
            Mixer mixer = AudioSystem.getMixer(mixerInfo);
            // Now Get Target Line
            Line.Info[] lineInfos = mixer.getTargetLineInfo();
            // Here again use for loop to list lines
            for(Line.Info lineInfo : lineInfos){
                // Make a null line
                Line line = null;
                // Make a boolean as opened
                boolean opened = true;
                // Now use try exception for opening a line
                try{
                    line = mixer.getLine(lineInfo);
                    opened = line.isOpen() || line instanceof Clip;
                    // Now Check If Line Is not Opened
                    if(!opened){
                        // Open Line
                        line.open();
                    }
                    // Make a float control
                    FloatControl volControl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                    // Get Current Volume Now
                    float currentVolume = volControl.getValue();
                    // Make a temp double variable and store valuePlusMinus
                    Double volumeToCut = valueToPlusMinus;
                    // Make a float and calculate the addition or subtraction in volume
                    float changedCalc = (float) ((float)currentVolume+(double)volumeToCut);
                    // Now Set This Changed Value Into Volume Line.
                    volControl.setValue(changedCalc);
                    
                }catch (LineUnavailableException lineException){
                }catch (IllegalArgumentException illException){
                }finally{
                    // Close Line If it opened
                    if(line != null && !opened){
                        line.close();
                    }
                }
            }
        }
    }
    
    // Let's Set Volume Method It's not necessary to remeber this code.
    private void volumeControl(Double valueToPlusMinus){
        // Get Mixer Information From AudioSystem
        Mixer.Info[] mixers = AudioSystem.getMixerInfo();
        // Now use a for loop to list all mixers
        for(Mixer.Info mixerInfo : mixers){
            // Get Mixer
            Mixer mixer = AudioSystem.getMixer(mixerInfo);
            // Now Get Target Line
            Line.Info[] lineInfos = mixer.getTargetLineInfo();
            // Here again use for loop to list lines
            for(Line.Info lineInfo : lineInfos){
                // Make a null line
                Line line = null;
                // Make a boolean as opened
                boolean opened = true;
                // Now use try exception for opening a line
                try{
                    line = mixer.getLine(lineInfo);
                    opened = line.isOpen() || line instanceof Clip;
                    // Now Check If Line Is not Opened
                    if(!opened){
                        // Open Line
                        line.open();
                    }
                    // Make a float control
                    FloatControl volControl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                    // Get Current Volume Now
                    float currentVolume = volControl.getValue();
                    // Make a temp double variable and store valuePlusMinus
                    Double volumeToCut = valueToPlusMinus;
                    // Make a float and calculate the addition or subtraction in volume
                    float changedCalc = (float) ((double)volumeToCut);
                    // Now Set This Changed Value Into Volume Line.
                    volControl.setValue(changedCalc);
                    
                }catch (LineUnavailableException lineException){
                }catch (IllegalArgumentException illException){
                }finally{
                    // Close Line If it opened
                    if(line != null && !opened){
                        line.close();
                    }
                }
            }
        }
    }
}
