$wnd.com_esofthead_mycollab_widgetset_MyCollabMobileWidgetSet.runAsyncCallback9("function sTc(){}\nfunction uTc(){}\nfunction wTc(){}\nfunction Jzd(){d3b.call(this)}\nfunction Z5b(a,b){return XL(a.q.To(b))}\nfunction W7d(){H2b.call(this);this.I=f$e;this.a=new dme}\nfunction N1c(c,a){var b=c;a.notifyChildrenOfSizeChange=pte(function(){b.vl()})}\nfunction V1c(b){try{b!=null&&eval('{ var document = $doc; var window = $wnd; '+b+'}')}catch(a){}}\nfunction K1c(b){if(b&&b.iLayoutJS){try{b.iLayoutJS();return true}catch(a){return false}}else{return false}}\nfunction J1c(a,b){var c,d;for(c=Nhe(new Ohe(a.f));c.a.Yg();){d=XL(Uhe(c));if(cM(a.f.To(d))===cM(b)){return d}}return null}\nfunction O1c(a,b){var c,d;d=J1c(a,b);d!=null&&a.f.Wo(d);c=VL(a.a.To(b),548);if(c){a.a.Wo(b);return ed(a,c)}else if(b){return ed(a,b)}return false}\nfunction L1c(a){var b,c,d;d=(nyb(),a.bc).getElementsByTagName('IMG');for(b=0;b<d.length;b++){c=d[b];lyb.Eg(c,oze)}}\nfunction P1c(a,b){var c,d,e;if((ju(),b).hasAttribute(sVe)){e=ou(b,sVe);a.e.Vo(e,b);Ut(b,'')}else{d=(nyb(),vAb(b));for(c=0;c<d;c++){P1c(a,uAb(b,c))}}}\nfunction Q1c(a,b,c){var d,e;if(!b){return}d=WL(a.e.To(c));if(!d&&a.d){throw new dee('No location '+c+' found')}e=VL(a.f.To(c),9);if(e==b){return}!!e&&O1c(a,e);a.d||(d=(nyb(),a.bc));Wc(a,b,(nyb(),d));a.f.Vo(c,b)}\nfunction R1c(a,b){var c,d,e;d=b.Rd();if(d.ac!=a){return}e=VL(a.a.To(d),548);if(Ddc(b.Pd())){if(!e){c=J1c(a,d);ed(a,d);e=new Ldc(b,a.b);Vc(a,e,WL(a.e.To(c)));a.a.Vo(d,e)}ydc(e.a)}else{if(e){c=J1c(a,d);ed(a,e);Vc(a,d,WL(a.e.To(c)));a.a.Wo(d)}}}\nfunction oTc(c){var d={setter:function(a,b){a.a=b},getter:function(a){return a.a}};c.Nk(bpb,b$e,d);var d={setter:function(a,b){a.b=b},getter:function(a){return a.b}};c.Nk(bpb,c$e,d);var d={setter:function(a,b){a.c=b},getter:function(a){return a.c}};c.Nk(bpb,d$e,d)}\nfunction S1c(){var a;fd.call(this);this.e=new dme;this.f=new dme;this.a=new dme;ob(this,(nyb(),$v($doc)));a=this.bc.style;Zx(a,RIe,(dy(),Bte));Zx(a,LKe,(HB(),eve));Zx(a,$Ke,eve);(t7b(),!s7b&&(s7b=new L7b),t7b(),s7b).a.i&&Zx(a,Ste,(MA(),uue));St(this.bc,f$e);Kb(this.bc,aUe,true)}\nfunction M1c(a,b,c){var d;b=I1c(a,b);d=Lfc(c+'/layouts/');b=kfe(b,'<((?:img)|(?:IMG))\\\\s([^>]*)src=\"((?![a-z]+:)[^/][^\"]+)\"',e$e+d+'$3\"');b=kfe(b,'<((?:img)|(?:IMG))\\\\s([^>]*)src=[^\"]((?![a-z]+:)[^/][^ />]+)[ />]',e$e+d+'$3\"');b=kfe(b,'(<[^>]+style=\"[^\"]*url\\\\()((?![a-z]+:)[^/][^\"]+)(\\\\)[^>]*>)','$1 '+d+'$2 $3');Ut((nyb(),a.bc),b);a.e.Kc();P1c(a,a.bc);L1c(a);a.c=uyb(a.bc);!a.c&&(a.c=a.bc);N1c(a,a.c);a.d=true}\nfunction Izd(a){var b,c,d;if(a.a){return}c=(!a.U&&(a.U=vg(a)),VL(VL(VL(a.U,6),118),396)).c;b=(!a.U&&(a.U=vg(a)),VL(VL(VL(a.U,6),118),396)).b;c!=null&&(b=Z5b(a.N,'layouts/'+c+'.html'));if(b!=null){M1c((!a.L&&(a.L=eh(a)),VL(a.L,266)),b,$5b(a.N))}else{d=c!=null?'Layout file layouts/'+c+'.html is missing.':'Layout file not specified.';Ut(eb((!a.L&&(a.L=eh(a)),VL(a.L,266))),'<em>'+d+' Components will be drawn for debug purposes.<\\/em>')}a.a=true}\nfunction I1c(a,b){var c,d,e,f,g,h,j,k;b=kfe(b,'_UID_',a.g+'__');a.i='';d=0;f=b.toLowerCase();h='';j=f.indexOf('<script',0);while(j>0){h+=b.substr(d,j-d);j=f.indexOf('>',j);e=f.indexOf('<\\/script>',j);a.i+=b.substr(j+1,e-(j+1))+';';g=d=e+9;j=f.indexOf('<script',g)}h+=vfe(b,d,b.length-d);f=h.toLowerCase();k=f.indexOf('<body');if(k<0){h=h}else{k=f.indexOf('>',k)+1;c=f.indexOf('<\\/body>',k);c>k?(h=h.substr(k,c-k)):(h=vfe(h,k,h.length-k))}return h}\nvar b$e='childLocations',c$e='templateContents',d$e='templateName',e$e='<$1 $2src=\"',f$e='v-customlayout';zub(1805,1,EKe);_.Me=function rTc(){hUc(this.b,bpb,rob);YTc(this.b,QOe,Phb);ZTc(this.b,Wcb,new sTc);ZTc(this.b,Phb,new uTc);ZTc(this.b,bpb,new wTc);fUc(this.b,Phb,Kue,new QTc(Wcb));fUc(this.b,Phb,Hue,new QTc(bpb));oTc(this.b);dUc(this.b,bpb,b$e,new RTc(NQe,OL(KL(kbb,1),fPe,4,0,[new QTc(Unb),new QTc(Grb)])));dUc(this.b,bpb,c$e,new QTc(Grb));dUc(this.b,bpb,d$e,new QTc(Grb));WTc(this.b,Phb,new GTc(Abb,kPe,OL(KL(Grb,1),rve,2,4,[fSe])));$xc((!Txc&&(Txc=new eyc),Txc),this.a.d)};zub(1807,1,OSe,sTc);_.Fk=function tTc(a,b){return new S1c};var Yab=sde(gNe,'ConnectorBundleLoaderImpl/9/1/1',1807);zub(1808,1,OSe,uTc);_.Fk=function vTc(a,b){return new Jzd};var Zab=sde(gNe,'ConnectorBundleLoaderImpl/9/1/2',1808);zub(1809,1,OSe,wTc);_.Fk=function xTc(a,b){return new W7d};var $ab=sde(gNe,'ConnectorBundleLoaderImpl/9/1/3',1809);zub(266,212,{14:1,12:1,11:1,13:1,26:1,33:1,15:1,29:1,10:1,9:1,266:1,20:1},S1c);_.Jc=function T1c(a){throw new Zfe};_.Kc=function U1c(){Qc(this);this.f.Kc();this.a.Kc()};_.vl=function W1c(){};_.uc=function X1c(a){Xb(this,a);nyb();if(hAb((ju(),a).type)==oze){ldc(this,true);gAb(a,true)}};_.vc=function Y1c(){Yb(this);!!this.c&&(this.c.notifyChildrenOfSizeChange=null,undefined)};_.Lc=function Z1c(a){return O1c(this,a)};_.lc=function $1c(a){St((nyb(),this.bc),a);Kb(this.bc,aUe,true)};_.d=false;_.i='';var Wcb=sde(Jue,'VCustomLayout',266);zub(1806,264,{7:1,16:1,124:1,93:1,134:1,24:1,27:1,34:1,28:1,264:1,152:1,257:1,30:1,3:1},Jzd);_.Pd=function Kzd(){return !this.U&&(this.U=vg(this)),VL(VL(VL(this.U,6),118),396)};_.Bd=function Lzd(){return !this.U&&(this.U=vg(this)),VL(VL(VL(this.U,6),118),396)};_.Ei=function Mzd(){return !this.U&&(this.U=vg(this)),VL(VL(VL(this.U,6),118),396)};_.Rd=function Nzd(){return !this.L&&(this.L=eh(this)),VL(this.L,266)};_.Dd=function Ozd(){(!this.L&&(this.L=eh(this)),VL(this.L,266)).b=this.N;(!this.L&&(this.L=eh(this)),VL(this.L,266)).g=this.P};_.Li=function Pzd(){K1c((!this.L&&(this.L=eh(this)),VL(this.L,266),uyb(eb((!this.L&&(this.L=eh(this)),VL(this.L,266))))))};_.oe=function Qzd(b){var c,d,e,f,g,h;Izd(this);for(d=hi(this).Rc();d.Yg();){c=VL(d.Zg(),16);e=XL((!this.U&&(this.U=vg(this)),VL(VL(VL(this.U,6),118),396)).a.To(c));try{Q1c((!this.L&&(this.L=eh(this)),VL(this.L,266)),c.Rd(),e)}catch(a){a=wub(a);if(ZL(a,38)){Pre(Rre((lde(Phb),Phb.k)),\"Child not rendered as no slot with id '\"+e+\"' has been defined\")}else throw vub(a)}}for(g=b.a.Rc();g.Yg();){f=VL(g.Zg(),16);if(f.zd()==this){continue}h=f.Rd();h.sc()&&O1c((!this.L&&(this.L=eh(this)),VL(this.L,266)),h)}};_.Fd=function Rzd(a){hh(this,a);Izd(this);V1c((!this.L&&(this.L=eh(this)),VL(this.L,266)).i);(!this.L&&(this.L=eh(this)),VL(this.L,266)).i=null};_.pe=function Szd(a){R1c((!this.L&&(this.L=eh(this)),VL(this.L,266)),a)};_.pi=function Tzd(a,b){};_.a=false;var Phb=sde('com.vaadin.client.ui.customlayout',vTe,1806);zub(396,118,{6:1,40:1,118:1,396:1,3:1},W7d);var bpb=sde('com.vaadin.shared.ui.customlayout','CustomLayoutState',396);pte(er)(9);\n//# sourceURL=com.esofthead.mycollab.widgetset.MyCollabMobileWidgetSet-9.js\n")